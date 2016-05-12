package br.com.cesar.android.sff;

import java.io.Serializable;

public abstract class GenericEntity  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected boolean newRecord = false;

	
	abstract public boolean isDuplicatedEntity();  
	
	public boolean isNewRecord() {
		return newRecord;
	}

	public void setNewRecord(boolean newRecord) {
		this.newRecord = newRecord;
	}

}
