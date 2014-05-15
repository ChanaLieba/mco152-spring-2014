package stein.flicker;

/**
 * The class that represents the json feed from Flicker
 */
public class FlickerFeed {

	private String title;
	private String link;
	private String description;
	private String modified;
	private String generator;
	private InsideItems[] items;
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		for(int i = 0; i<items.length; i++){
			sb.append(items[i].toString());
			sb.append("\n");
		}
		return "FlickerFeed [title=" + title + ", link=" + link
				+ ", description=" + description + ", modified=" + modified
				+ ", generator=" + generator + ", items="
				+ sb + "]";
	}
	
	public String[] getItems(){
		String[] itemsArray = new String[items.length];
		for(int i = 0; i<items.length; i++){
			itemsArray[i] = items[i].getMedia().getM();
		}
		return itemsArray;
	}

	public String getTitle() {
		return title;
	}

	public String getLink() {
		return link;
	}

	public String getDescription() {
		return description;
	}

	public String getModified() {
		return modified;
	}

	public String getGenerator() {
		return generator;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public void setGenerator(String generator) {
		this.generator = generator;
	}

	public void setItems(InsideItems[] items) {
		this.items = items;
	}
	
	
	
	

}
