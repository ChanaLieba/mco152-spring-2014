package stein.mtamap;
 
 
public class Trip{
	
	   private  String routeId;
	   private  String shapeId;
 
    public Trip(String routeId, String shapeId){
        this.routeId = routeId;
        this.shapeId = shapeId;
    }
 
    public int hashCode(){
        int prime = 31;
        int result = 1;
        result = 31 * result + (routeId != null ? routeId.hashCode() : 0);
        result = 31 * result + (shapeId != null ? shapeId.hashCode() : 0);
        return result;
    }
 
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        Trip other = (Trip)obj;
        if(routeId == null)
        {
            if(other.routeId != null)
                return false;
        } else
        if(!routeId.equals(other.routeId))
            return false;
        if(shapeId == null)
        {
            if(other.shapeId != null)
                return false;
        } else
        if(!shapeId.equals(other.shapeId))
            return false;
        return true;
    }
 
    public String getRouteId(){
        return routeId;
    }
 
    public String getShapeId(){
        return shapeId;
    }
 
 
}

