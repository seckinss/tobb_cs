
public abstract class AbstractBoard implements BoardInterface{
	
	Item [] items=new Item[32];
	public void setItems(Item[] items) {
		this.items = items;
	}
	public Item[] getItems() {
		return items;
	}
	
}
