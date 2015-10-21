package com.tutorialcrud.conversor;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import com.tutorialcrud.dao.DisciplinaRepository;
import com.tutorialcrud.dominio.Disciplina;
import com.tutorialcrud.util.JpaUtil;

@FacesConverter(forClass = Disciplina.class)
public class DisciplinaConverter implements Converter {

	EntityManager manager = JpaUtil.getEntityManager();

	private DisciplinaRepository disciplinas = new DisciplinaRepository(manager);

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Disciplina retorno = null;
		if (value != null && !"".equals(value)) {
			retorno = this.disciplinas.porId(new Long(value));
		}
		return retorno;

	}

	@Override
	public String getAsString(FacesContext context, UIComponent componet, Object value) {
		if (value != null) {
			Disciplina disciplina = ((Disciplina) value);
			return disciplina.getId() == null ? null : disciplina.getId().toString();
		}
		return null;

	}

}
