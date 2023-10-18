import java.io.Serializable;

public class Board extends AbstractBoard implements Serializable{
	Board(){
		items[0]=new KItem("Black", "j1");
		items[1]=new AItem("Black", "j2");
		items[2]=new FItem("Black", "j3");
		items[3]=new VItem("Black", "j4");
		items[4]=new SItem("Black", "j5");
		items[5]=new VItem("Black", "j6");
		items[6]=new FItem("Black", "j7");
		items[7]=new AItem("Black", "j8");
		items[8]=new KItem("Black", "j9");
		items[9]=new TItem("Black", "h2");
		items[10]=new TItem("Black", "h8");
		items[11]=new NormalPItem("Black","g1");
		items[12]=new NormalPItem("Black","g3");
		items[13]=new NormalPItem("Black","g5");
		items[14]=new NormalPItem("Black","g7");
		items[15]=new NormalPItem("Black","g9");
		items[16]=new NormalPItem("Red","d1");
		items[17]=new NormalPItem("Red","d3");
		items[18]=new NormalPItem("Red","d5");
		items[19]=new NormalPItem("Red","d7");
		items[20]=new NormalPItem("Red","d9");
		items[21]=new TItem("Red", "c2");
		items[22]=new TItem("Red", "c8");
		items[23]=new KItem("Red", "a1");
		items[24]=new AItem("Red","a2");
		items[25]=new FItem("Red","a3");
		items[26]=new VItem("Red", "a4");
		items[27]=new SItem("Red", "a5");
		items[28]=new VItem("Red", "a6");
		items[29]=new FItem("Red", "a7");
		items[30]=new AItem("Red", "a8");
		items[31]=new KItem("Red", "a9");
	}
	@Override
	public void print() {
		int k=0;
		for (int i = 0; i < 90; i++) {
			int z=-1;
			if(i%9==0){
				System.out.print((char)('j'-k) + "\t");
				k++;
			}
			for(int j = 0; j < items.length; j++) {
				if(items[j].getPosition().equals(""+(char)(106-i/9)+(char)(i%9+49))){
					if(items[j].isAlive){
						z=j;
						break;
					}
				}
			}
			if(z!=-1)
				System.out.print(items[z]);
			else
				System.out.print("-");
			if(i%9!=8){
					System.out.print("--");
				}
			else{
				System.out.println();
				if(i==8||i==80)
				System.out.println(" \t|  |  |  |\\ | /|  |  |  |");
				if(i==17||i==71)
				System.out.println(" \t|  |  |  |/ | \\|  |  |  |");
				if(i==26||i==35||i==53||i==62)
				System.out.println(" \t|  |  |  |  |  |  |  |  |");
				if(i==44)
				System.out.println(" \t|                       |");
			}
		}
		System.out.println();
		System.out.println(" \t1--2--3--4--5--6--7--8--9");
	}
	public String printStr() {
		int k=0;
		String s="";
		for (int i = 0; i < 90; i++) {
			int z=-1;
			if(i%9==0){
				s+=(char)('j'-k) + "\t";
				k++;
			}
			for(int j = 0; j < items.length; j++) {
				if(items[j].getPosition().equals(""+(char)(106-i/9)+(char)(i%9+49))){
					if(items[j].isAlive){
						z=j;
						break;
					}
				}
			}
			if(z!=-1)
				s+=items[z];
			else
				s+="-";
			if(i%9!=8){
					s+="--";
				}
			else{
				s+="\n";
				if(i==8||i==80)
				s+=" \t|  |  |  |\\ | /|  |  |  |\n";
				if(i==17||i==71)
				s+=" \t|  |  |  |/ | \\|  |  |  |\n";
				if(i==26||i==35||i==53||i==62)
				s+=" \t|  |  |  |  |  |  |  |  |\n";
				if(i==44)
				s+=" \t|                       |\n";
			}
		}
		s+="\n";
		s+=" \t1--2--3--4--5--6--7--8--9\n";
		return s;
	}
}