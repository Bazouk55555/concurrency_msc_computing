
public class Distinct {
	public static Boolean distinction1(int array [] ){
		for(int i=0;i<array.length-1;i++){
			for(int j=i+1;j<array.length;j++){
				if(array[i]==array[j]){
					return false;
				}
			}
		}
		return true;
	}

	public static Boolean distinction2(int array [] ){
		for(int i=0;i<array.length-1;i++){
			for(int j=0;j<array.length;j++){
				if(i!=j&&array[i]==array[j]){
					return false;
				}
			}
		}
		return true;
	}
	
	
	public static void main(String [ ] args){

		int[] a= new int [4];
		System.out.println(a[3]);
	}
}