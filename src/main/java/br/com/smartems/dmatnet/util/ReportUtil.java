package br.com.smartems.dmatnet.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

@Local
@Stateless
@SuppressWarnings("deprecation")
public class ReportUtil {
	@SuppressWarnings("rawtypes")
	public void GerarRelatorio (List lista, String caminhoRelatorio, String nomeRelatorio) {
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(lista);
		try {
			String reportPath = FacesContext.getCurrentInstance().getExternalContext()
					.getRealPath("/report/CadastroEmpresa.jasper");
			JasperPrint jasperPrint = JasperFillManager.fillReport(reportPath, null, beanCollectionDataSource);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.responseComplete();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			JRPdfExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
			exporter.exportReport();
			byte[] bytes = baos.toByteArray();

			if (bytes != null && bytes.length > 0) {
				HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
				response.setContentType("application/pdf");
				response.setHeader("Content-disposition", "attachment; filename=\"" + nomeRelatorio +".pdf\"");
				response.setContentLength(bytes.length);
				ServletOutputStream outputStream = response.getOutputStream();
				outputStream.write(bytes, 0, bytes.length);
				outputStream.flush();
				outputStream.close();
			}

		} catch (JRException | IOException e) {
			e.printStackTrace();
		}
	}
}
