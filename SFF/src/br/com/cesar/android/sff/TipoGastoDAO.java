package br.com.cesar.android.sff;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class TipoGastoDAO {

	private SQLiteDatabase database;
	public static final String TABLE_NAME = "tipo_gasto";
	public static final String COLUMN_ID = " id ";
	public static final String COLUMN_VERSAO = " versao ";
	public static final String COLUMN_DESCRICAO = " descricao ";
	public static final String COLUMN_DESATIVADO = " desativado ";
	private SQLiteHelper SQLiteHelper;
	private String[] columns = new String[] { COLUMN_ID, COLUMN_VERSAO,
			COLUMN_DESCRICAO, COLUMN_DESATIVADO };

	public TipoGastoDAO(Context context) {
		this.SQLiteHelper = new  SQLiteHelper(context );
	}
	
	public void open(){
		this.database = this.SQLiteHelper.getWritableDatabase();
	}

	public void close(){
		this.SQLiteHelper.close();
	}
	
	public void insert(TipoGasto tipoGasto){
		ContentValues values = new ContentValues();
		values.put(COLUMN_ID, tipoGasto.getId());
		values.put(COLUMN_VERSAO, tipoGasto.getVersao());
		values.put(COLUMN_DESCRICAO, tipoGasto.getDescricao());
		values.put(COLUMN_DESATIVADO, tipoGasto.isDesativado() ? 1 : 0);
		database.insert(TABLE_NAME, null, values);
		
	}
	
	public void delete(TipoGasto tipoGasto){
		delete(tipoGasto.getId());
		
	}
	
	public void delete(Long tipoGastoId){
		long id = tipoGastoId;
		database.delete(TABLE_NAME, COLUMN_ID +" = " + id, null);
	}

	public List<TipoGasto> getAll(){
		List<TipoGasto> tipoGatoList = new ArrayList<TipoGasto>();
		
		Cursor cursor = database.query(TABLE_NAME, columns, null, null, null, null, null);
		cursor.moveToFirst();
		
		while ((!cursor.isAfterLast ())) {
			TipoGasto tipoGasto =  new TipoGasto();
			tipoGasto.setId(cursor.getLong(0));
			tipoGasto.setVersao(cursor.getLong(1));
			tipoGasto.setDescricao(cursor.getString(2));
			tipoGasto.setDesativado(cursor.getInt(3) == 1 ? true: false );
			
		}
		
		return tipoGatoList;
	}
}
