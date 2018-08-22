package br.com.smartems.dmatnet.EJB.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.smartems.dmatnet.entities.ClassificacaoFuncional.ClassificacaoFuncionalEntity;

@Stateless
@Local
public class ClassificacaoFuncionalEAO extends AbstractEAO<ClassificacaoFuncionalEntity, Long> {
       
    public ClassificacaoFuncionalEAO() {
        super(ClassificacaoFuncionalEntity.class);
    }

}
