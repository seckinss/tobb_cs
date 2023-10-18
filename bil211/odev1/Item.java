import java.io.Serializable;

public class Item extends AbstractItem implements Serializable{
	boolean isAlive=true;
	float pointVal=0;
	static int staticItemNum=0;
	int itemNum=0;
	static Item[] arr=new Item[32*2000];
	String color="";
	@Override
	public void move(String destination) {
	
	}
	public boolean isNotIllegalMove(String des){
		String pos=this.getPosition();
		this.setPosition(des);
		String kingPos1="";
		String kingPos2="";
		for (int i = itemNum/32*32;i>=itemNum/32*(32)&&i<itemNum/32*32+32; i++) {
			if(arr[i] instanceof SItem){
				if(!arr[i].color.equals(color))
					kingPos1=arr[i].getPosition();
				else
					kingPos2=arr[i].getPosition();
			}
		}
		if(kingPos1.charAt(1)==kingPos2.charAt(1)){
			if(kingPos1.charAt(0)>kingPos2.charAt(0)){
				for (int i=1;i<kingPos1.charAt(0)-kingPos2.charAt(0);i++) {
					if(!isEmpty(""+(char)(kingPos2.charAt(0)+i)+(char)kingPos2.charAt(1))){
						this.setPosition(pos);
						return true;
					}
				}
				this.setPosition(pos);
				return false;
			}
			if(kingPos1.charAt(0)<kingPos2.charAt(0)){
				for (int i = 1; i < kingPos2.charAt(0)-kingPos1.charAt(0); i++) {
					if(!isEmpty(""+(char)(kingPos1.charAt(0)+i)+(char)kingPos1.charAt(1))){
						this.setPosition(pos);
						return true;
					}
				}
				this.setPosition(pos);
				return false;
			}
		}
		this.setPosition(pos);
		return true;
	}
	public boolean isCheckMate(){
		int z=0;
		if(color.equals("Black"))
			z=16;
		for (int i = itemNum/32*32+z;i>=itemNum/32*(32)&&i<itemNum/32*32+16+z; i++) {
			if(arr[i].canMove(getPosition())) 
				return false;
			for (int j = 0; j < 90; j++) {
				String k=""+(char)(97+j/9)+(char)(j%9+49);
				if(arr[i].canMove(k)){
					return false;
				}
			}
		}

		return true;
	}
	public boolean isCheck(){
		int z=0;
		if(color.equals("Black"))
			z=16;
		String cantCome="";
		for (int i = itemNum/32*32+z;i>=itemNum/32*(32)&&i<itemNum/32*32+z+16; i++) {
			if(arr[i] instanceof SItem)
				if(!arr[i].color.equals(color))
					cantCome=arr[i].getPosition();
		}
		for (int i = itemNum/32*32-z+16;i>=itemNum/32*(32)&&i<itemNum/32*32-z+32; i++) {
			if(arr[i].canMove(cantCome)){
				return true;
			}
		}
		return false;
	}
	
	public boolean isIllegalCheck(String des){
		String pos1=getPosition();
		setPosition(des);
		String cantCome="";
		for (int i = itemNum/32*32;i>=itemNum/32*(32)&&i<itemNum/32*32+32; i++) {
			if(arr[i] instanceof SItem)
				if(arr[i].color.equals(color))
					cantCome=arr[i].getPosition();
		}
		for (int i = itemNum/32*32;i>=itemNum/32*(32)&&i<itemNum/32*32+32; i++) {
			if(!arr[i].color.equals(color)){
				if(arr[i].canMove(cantCome)){
					if(!arr[i].getPosition().equals(des)){
						setPosition(pos1);
						return false;
					}
				}
			}
		}
		setPosition(pos1);
		return true;
	}
	public boolean canMove(String destination){
		//will override.
		return false;
	}
	public boolean isEmpty(String pos){
		for (int i = itemNum/32*32;i>=itemNum/32*(32)&&i<itemNum/32*32+32; i++) {
			if(arr[i].getPosition().equals(pos))
				return false;
		}
		return true;
	}
	public boolean hasEnemy(String pos){
		for (int i = itemNum/32*32;i>=itemNum/32*(32)&&i<itemNum/32*32+32; i++) {
			if(arr[i].getPosition().equals(pos)){
				if(!(arr[i].color.equals(this.color)))
					return true;		
			}
		}
		return false;
	}
	public boolean isOnBoard(String des){
		if(des.length()!=2)
			return false;
		if(des.charAt(0)<=106&&97<=des.charAt(0))
			if(des.charAt(1)<='9'&&des.charAt(1)>='1')
				return true;
		
		return false;
			
	}
	public void eatEnemy(String pos){
		for (int i = itemNum/32*32;i>=itemNum/32*(32)&&i<itemNum/32*32+32; i++) {
			if(arr[i].getPosition().equals(pos)){
				arr[i].isAlive=false;
				arr[i].setPosition("xx");
				return;
			}
		}
	}
	Item(){
		arr[staticItemNum]=this;
		staticItemNum++;
		itemNum=staticItemNum-1;
	}
	Item(String color,String pos){
		this();
		this.color=color;
		setPosition(pos);
		pointVal=1;
	}
}
class KItem extends Item{
	String color="";
	String symbol="k";
	KItem(String color,String pos){
		super(color,pos);
		if(color.equals("Black")){
			symbol=symbol.toUpperCase();
		}
		this.color=color;
		setPosition(pos);
		pointVal=9;
	}
	@Override
	public void move(String destination) {
		if(canMove(destination)){
			if(hasEnemy(destination))
				eatEnemy(destination);
			setPosition(destination);
			return;
		}
	}
	public String toString(){
		return symbol;
	}
	public boolean canMove(String des){
		if(getPosition().charAt(0)-des.charAt(0)<0)
			return isOnBoard(des) && (isEmpty(des)||hasEnemy(des))&& accuratePattern(des)&& canMoveRecursive(getPosition(),""+(char)(des.charAt(0)-1)+(char)des.charAt(1))&&isIllegalCheck(des)&&isNotIllegalMove(des);
		if(getPosition().charAt(0)-des.charAt(0)>0)
			return isOnBoard(des) && (isEmpty(des)||hasEnemy(des))&& accuratePattern(des)&& canMoveRecursive(getPosition(),""+(char)(des.charAt(0)+1)+(char)des.charAt(1))&&isIllegalCheck(des)&&isNotIllegalMove(des);
		if(getPosition().charAt(1)-des.charAt(1)>0)
			return isOnBoard(des) && (isEmpty(des)||hasEnemy(des))&& accuratePattern(des)&& canMoveRecursive(getPosition(),""+(char)(des.charAt(0))+(char)(des.charAt(1)+1))&&isIllegalCheck(des)&&isNotIllegalMove(des);
		if(getPosition().charAt(1)-des.charAt(1)<0)
			return isOnBoard(des) && (isEmpty(des)||hasEnemy(des))&& accuratePattern(des)&& canMoveRecursive(getPosition(),""+(char)(des.charAt(0))+(char)(des.charAt(1)-1))&&isIllegalCheck(des)&&isNotIllegalMove(des);
		return false;
	}
	private boolean accuratePattern(String des) {
		if(getPosition().charAt(0)-des.charAt(0)!=0){
			if(getPosition().charAt(1)-des.charAt(1)==0)
				return true;
		}
		if(getPosition().charAt(0)-des.charAt(0)==0){
			if(getPosition().charAt(1)-des.charAt(1)!=0)
				return true;
		}
		return false;	
	}	
	private boolean canMoveRecursive(String pos,String des){
		if(pos.equals(des))
			return true;
		if(!isEmpty(des))
			return false;
		if(pos.charAt(0)-des.charAt(0)==0){
			if(pos.charAt(1)-des.charAt(1)>0)
				return canMoveRecursive(pos,""+(char)des.charAt(0)+(char)(des.charAt(1)+1));
			if(pos.charAt(1)-des.charAt(1)<0)
			return canMoveRecursive(pos,""+(char)des.charAt(0)+(char)(des.charAt(1)-1));
		}
		if(pos.charAt(0)-des.charAt(0)<0)
			return canMoveRecursive(pos,""+(char)(des.charAt(0)-1)+(char)des.charAt(1));
		if(pos.charAt(0)-des.charAt(0)>0)
			return canMoveRecursive(pos,""+(char)(des.charAt(0)+1)+(char)des.charAt(1));
		return false;
	}
}
class AItem extends Item{
	String symbol="a";
	AItem(String color,String pos){
		super(color,pos);
		if(color.equals("Black")){
			symbol=symbol.toUpperCase();
		}
		this.color=color;
		setPosition(pos);
		pointVal=4;
	}
	public String toString(){
		return symbol;
	}
	private boolean accuratePattern(String destination){
		if(Math.abs(destination.charAt(0)-getPosition().charAt(0))==2 && Math.abs(destination.charAt(1)-getPosition().charAt(1))==1)
			if(isEmpty(""+(char)((getPosition().charAt(0)+destination.charAt(0))/2)+(char)getPosition().charAt(1)))
				return true;
			
		if(Math.abs(destination.charAt(0)-getPosition().charAt(0))==1 && Math.abs(destination.charAt(1)-getPosition().charAt(1))==2)
			if(isEmpty(""+(char)getPosition().charAt(0)+(char)((getPosition().charAt(1)+destination.charAt(1))/2)))
				return true;
		return false;
	}
	public boolean canMove(String des) {
		return isOnBoard(des)&&(isEmpty(des)||hasEnemy(des))&& accuratePattern(des)&&isIllegalCheck(des)&&isNotIllegalMove(des);
	}
	@Override
	public void move(String destination) {
		if(canMove(destination)){
			if(hasEnemy(destination))
				eatEnemy(destination);
			setPosition(destination);
			return;
		}
	}
}
class FItem extends Item{
	String symbol="f";
	FItem(String color,String pos){
		if(color.equals("Black")){
			symbol=symbol.toUpperCase();
		}
		this.color=color;
		setPosition(pos);
		pointVal=2;
	}
	public String toString(){
		return symbol;
	}
	public boolean accuratePattern(String destination){
		if(Math.abs(destination.charAt(0)-getPosition().charAt(0))==2 && Math.abs(destination.charAt(1)-getPosition().charAt(1))==2)
			if((isEmpty(""+ (char)((destination.charAt(0)+getPosition().charAt(0))/2) + (char)((destination.charAt(1)+getPosition().charAt(1))/2))))
				if(!((destination.charAt(0)=='g'&&getPosition().charAt(0)=='e')||(destination.charAt(0)=='d'&&getPosition().charAt(0)=='f')))
					return true;
		return false;
	}
	public boolean canMove(String des){
		return isOnBoard(des)&&(isEmpty(des)||hasEnemy(des))&& accuratePattern(des)&&isIllegalCheck(des)&&isNotIllegalMove(des);
	}
	public void move(String destination) {
		if(canMove(destination)){
			if(hasEnemy(destination))
				eatEnemy(destination);
			setPosition(destination);
			return;
		}
	}
}
class VItem extends Item {
	String symbol="v";
	VItem(String color,String pos){
		super(color,pos);
		if(color.equals("Black")){
			symbol=symbol.toUpperCase();
		}
		this.color=color;
		setPosition(pos);
		pointVal=2;
	}
	public String toString(){
		return symbol;
	}
	@Override
	public void move(String destination) {
		if(canMove(destination)){
			if(hasEnemy(destination))
				eatEnemy(destination);
			setPosition(destination);
			return;
		}
	}
	@Override
	public boolean canMove(String des) {
		return isOnBoard(des)&&(isEmpty(des)||hasEnemy(des))&& accuratePattern(des)&&isIllegalCheck(des)&&isNotIllegalMove(des);
	}
	private boolean accuratePattern(String des){
		if(Math.abs(des.charAt(0)-getPosition().charAt(0))==1&&Math.abs(des.charAt(1)-getPosition().charAt(1))==1&&'4'<=des.charAt(1)&&'6'>=des.charAt(1)){
			if(color.equals("Black")){
				if(des.charAt(0)>='h'&&des.charAt(0)<='j')
					return true;
			}
			if(color.equals("Red")){
				if(des.charAt(0)>='a'&&des.charAt(0)<='c')
					return true;
			}
		}
		return false;
	}
}
class SItem extends Item {
	String symbol="ş";
	SItem(String color,String pos){
		super(color,pos);
		if(color.equals("Black")){
			symbol=symbol.toUpperCase();
		}
		this.color=color;
		setPosition(pos);
		pointVal=1000;
	}
	public String toString(){
		return symbol;
	}
	private boolean accuratePattern(String des){
		if(((Math.abs(des.charAt(0)-getPosition().charAt(0))==1&&Math.abs(des.charAt(1)-getPosition().charAt(1))==0)||(Math.abs(des.charAt(0)-getPosition().charAt(0))==0&&Math.abs(des.charAt(1)-getPosition().charAt(1))==1))&&'4'<=des.charAt(1)&&'6'>=des.charAt(1)){
			if(color.equals("Black")){
				if(des.charAt(0)>='h'&&des.charAt(0)<='j')
					return true;
			}
			if(color.equals("Red")){
				if(des.charAt(0)>='a'&&des.charAt(0)<='c')
					return true;
			}
		}
		return false;
	}

	@Override
	public boolean canMove(String des) {
		return isOnBoard(des)&&(isEmpty(des)||hasEnemy(des))&& accuratePattern(des)&&isIllegalCheck(des)&&isNotIllegalMove(des);
	}
	
	@Override
	public void move(String destination) {
		if(canMove(destination)){
			if(hasEnemy(destination))
				eatEnemy(destination);
			setPosition(destination);
			return;
		}
	}

}
class TItem extends Item {
	String symbol="t";
	TItem(String color,String pos){
		super(color,pos);
		if(color.equals("Black")){
			symbol=symbol.toUpperCase();
		}
		this.color=color;
		setPosition(pos);
		pointVal=4.5f;
	}
	public String toString(){
		return symbol;
	}
	private boolean accuratePattern(String des){
		int obstacleC=0;
		boolean control=true;
		if(hasEnemy(des)){
			if(getPosition().charAt(0)!=des.charAt(0)){
				if(getPosition().charAt(1)!=des.charAt(1))
					return false;
				if(getPosition().charAt(0)-des.charAt(0)<0){
					for (int i = 1; i < des.charAt(0)-getPosition().charAt(0); i++) {
						if(!(isEmpty(""+(char)(getPosition().charAt(0)+i)+(char)getPosition().charAt(1))))
							obstacleC++;
					}
				}
				if(getPosition().charAt(0)-des.charAt(0)>0){
					for (int i = 1; i < getPosition().charAt(0)-des.charAt(0); i++) {
						if(!(isEmpty(""+(char)(getPosition().charAt(0)-i)+(char)getPosition().charAt(1))))
							obstacleC++;
						
					}
				}		
			}
			if(getPosition().charAt(0)==des.charAt(0)){
				if(getPosition().charAt(1)==des.charAt(1))
					return false;
				if(getPosition().charAt(1)-des.charAt(1)<0){
					for (int i = 1; i < des.charAt(1)-getPosition().charAt(1); i++) {
						if(!isEmpty(""+(char)getPosition().charAt(0)+(char)(getPosition().charAt(1)+i)))
							obstacleC++;
					}
				}
				if(getPosition().charAt(1)-des.charAt(1)>0){
					for (int i = 1; i < getPosition().charAt(1)-des.charAt(1); i++) {
						if(!isEmpty(""+(char)getPosition().charAt(0)+(char)(getPosition().charAt(1)-i)))
							obstacleC++;
					}
				}
			}
			if(obstacleC==1)
				return true;
			return false;
		}
		else{
			if(getPosition().charAt(0)!=des.charAt(0)){
				if(!(getPosition().charAt(1)==des.charAt(1)))
					return false;
				if(getPosition().charAt(0)-des.charAt(0)<0){
					for (int i = 1; i <= des.charAt(0)-getPosition().charAt(0); i++) {
						control=control&&isEmpty(""+(char)(getPosition().charAt(0)+i)+(char)getPosition().charAt(1));
					}
					return control;
				}
				if(getPosition().charAt(0)-des.charAt(0)>0){
					for (int i = 1; i <= getPosition().charAt(0)-des.charAt(0); i++) {
						control=control&&isEmpty(""+(char)(getPosition().charAt(0)-i)+(char)(getPosition().charAt(1)));
					}
					return control;
				}		
			}
			if(getPosition().charAt(0)==des.charAt(0)){
				if(getPosition().charAt(1)-des.charAt(1)<0){
					for (int i = 1; i <= des.charAt(1)-getPosition().charAt(1); i++) {
						control=control&&isEmpty(""+(char)getPosition().charAt(0)+(char)(getPosition().charAt(1)+i));
					}
					return control;
				}
				if(getPosition().charAt(1)-des.charAt(1)>0){
					for (int i = 1; i <= getPosition().charAt(1)-des.charAt(1); i++) {
						control=control&&isEmpty(""+(char)getPosition().charAt(0)+(char)(getPosition().charAt(1)-i));
					}
					return control;
				}
			}
		}
		return false;
	}
	@Override
	public boolean canMove(String destination) {
		return isOnBoard(destination)&&(isEmpty(destination)||hasEnemy(destination))&&accuratePattern(destination)&&isIllegalCheck(destination)&&isNotIllegalMove(destination);
	}
	@Override
	public void move(String destination) {
		if(canMove(destination)){
			if(hasEnemy(destination))
				eatEnemy(destination);
			setPosition(destination);
			return;
		}
	}
}
class NormalPItem extends Item{
	int movecount=0;
	String symbol="p";
	NormalPItem(String color,String pos){
		super(color,pos);
		if(color.equals("Black")){
			symbol=symbol.toUpperCase();
		}
		this.color=color;
		setPosition(pos);
		pointVal=1;
	}
	private boolean accuratePattern(String destination){
		if(color.equals("Black")){
			if(movecount>=2){
				if(destination.charAt(0)-getPosition().charAt(0)==0)
				if(Math.abs(destination.charAt(1)-getPosition().charAt(1))==1)
				return true;
			}
			if(destination.charAt(0)-getPosition().charAt(0)==-1)
			if(destination.charAt(1)-getPosition().charAt(1)==0)
			return true;	
		}
		if(color.equals("Red")){
			if(movecount>=2){
				if(destination.charAt(0)-getPosition().charAt(0)==0)
				if(Math.abs(destination.charAt(1)-getPosition().charAt(1))==1)
				return true;
			}
			if(destination.charAt(0)-getPosition().charAt(0)==1)
			if(destination.charAt(1)-getPosition().charAt(1)==0)
			return true;
		}
		return false;
	}
	public boolean canMove(String checkouter){
		return isOnBoard(checkouter)&&(isEmpty(checkouter)||hasEnemy(checkouter))&&accuratePattern(checkouter)&&isIllegalCheck(checkouter)&&isNotIllegalMove(checkouter);
	}
	public void move(String destination){
		if(canMove(destination)){
			if(hasEnemy(destination))
				eatEnemy(destination);
			movecount++;
			setPosition(destination);	
			return;
			}
		}
	
	public String toString(){
		return symbol;
	}
}
