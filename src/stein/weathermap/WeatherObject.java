package stein.weathermap;

public class WeatherObject {
	
	private Long dt;
	private MainObject main;
	public Long getDt() {
		return dt;
	}
	public void setDt(Long dt) {
		this.dt = dt;
	}
	public MainObject getMain() {
		return main;
	}
	public void setMain(MainObject main) {
		this.main = main;
	}
	public Double getTemp(){
		return main.getTemp();
	}
	@Override
	public String toString() {
		return "WeatherObject [dt=" + dt + ", main=" + main + "]";
	}
	
	

}
