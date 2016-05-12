package br.com.cesar.android.sff;

public interface ListSearchListener {

	void startSearch();
	
	void stopSearch();
	
	void performSearch(String query);
}
