package br.com.smartems.dmatnet.DAO;

import javax.ejb.Local;
import javax.ejb.Stateless;

import br.com.smartems.dmatnet.entities.ClassificacaoFuncional.ClassificacaoFuncionalEntity;

@Stateless
@Local
public class ClassificacaoFuncionalDAO extends AbstractDAO<ClassificacaoFuncionalEntity, Long> {
       
    public ClassificacaoFuncionalDAO() {
        super(ClassificacaoFuncionalEntity.class);
    }

}
