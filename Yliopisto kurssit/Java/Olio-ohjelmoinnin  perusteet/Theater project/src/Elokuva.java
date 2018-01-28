
public class Elokuva{
	public String elokuvanNimi;
	public String elokuvanAika;
	 
	public Elokuva(String elokuvanNimi, String elokuvanAika){
		 this.elokuvanAika = elokuvanAika;
		 this.elokuvanNimi = elokuvanNimi;
	 }

	 public void asetaElokuvanNimi(String elokuvanNimi){
		 this.elokuvanNimi = elokuvanNimi;
	 }
	 
	 public String annaElokuvanNimi(){
		 return elokuvanNimi;
	 }

	 public void asetaElokuvanAika(String elokuvanAika){
		 this.elokuvanNimi = elokuvanAika;
	 }

	 public String annaElokuvanAika(){
		 return elokuvanAika;
	 }
	 
	 public String toString() {
		  return elokuvanNimi + ", aika: " + elokuvanAika;
		 }	 
}
	  





