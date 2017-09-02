package model;

public class FileDownloaded {
	private String url, name;
	
	public FileDownloaded() {
		this.setUrl("No available");
		this.setName("No available");
	}

	public FileDownloaded(String url, String name) {
		this.setUrl(url);
		this.setName(name);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "File [url=" + url + ", name=" + name + "]";
	}

}
