package br.com.smartems.dmatnet.entities.LevAmbientais;

import java.io.Serializable;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import br.com.smartems.dmatnet.entities.pessoa.ExameMedicoEntity;

@MappedSuperclass
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class AbstractRisco implements Serializable, IRisco {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String codFatorRisco_tab21;
	private String codFatorRisco_tab22;
	private String codFatorRisco_tab23;
	private String dadosComprometimentoSaude;
	private List<ExameMedicoEntity> examesMedicos;
	
	private static final long serialVersionUID = 1L;
}
