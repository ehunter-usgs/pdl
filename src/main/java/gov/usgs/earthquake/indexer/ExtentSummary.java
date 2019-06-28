/**
 * Extent Index Query
 */

package gov.usgs.earthquake.indexer;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import gov.usgs.earthquake.indexer.ProductSummary;
import gov.usgs.util.XmlUtils;

public class ExtentSummary {
  private Long id;
  private Date startTime;
  private Date endTime;
  private Double maxLatitude;
  private Double minLatitude;
  private Double maxLongitude;
  private Double minLongitude;

  public ExtentSummary() {
    //Do nothing; this is if member vars are to be set manually
  }

  public ExtentSummary(ProductSummary product) {
    Map<String,String> properties = product.getProperties();

    id = product.getIndexId();
    
    Iterator<String> iterator = properties.keySet().iterator();
    while (iterator.hasNext()) {
      String property = iterator.next();
      if (property == ExtentIndex.EXTENT_START_TIME) {
        startTime = XmlUtils.getDate(properties.get(ExtentIndex.EXTENT_START_TIME));
      } else if (property == ExtentIndex.EXTENT_END_TIME) {
        endTime = XmlUtils.getDate(properties.get(ExtentIndex.EXTENT_END_TIME));
      } else if (property == ExtentIndex.EXTENT_MAX_LAT) {
        maxLatitude = Double.parseDouble(properties.get(ExtentIndex.EXTENT_MAX_LAT));
      } else if (property == ExtentIndex.EXTENT_MAX_LONG) {
        maxLongitude = Double.parseDouble(properties.get(ExtentIndex.EXTENT_MAX_LONG));
      } else if (property == ExtentIndex.EXTENT_MIN_LAT) {
        minLatitude = Double.parseDouble(properties.get(ExtentIndex.EXTENT_MIN_LAT));
      } else if (property == ExtentIndex.EXTENT_MIN_LONG) {
        minLongitude = Double.parseDouble(properties.get(ExtentIndex.EXTENT_MIN_LONG));
      }
    }
  }

  public boolean isValid() {
    return 
      startTime != null || 
      endTime != null || 
      maxLatitude != null || 
      maxLongitude != null || 
      minLatitude != null || 
      minLongitude != null;
  }

  public Long getId() {
    return this.id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  public Date getStartTime() {
    return this.startTime;
  }
  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }
  
  public Date getEndTime() {
    return this.endTime;
  }
  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }

  public Double getMaxLatitude() {
    return this.maxLatitude;
  }
  public void setMaxLatitude(Double maxLatitude) {
    this.maxLatitude = maxLatitude;
  }

  public Double getMinLatitude() {
    return this.minLatitude;
  }
  public void setMinLatitude(Double minLatitude) {
    this.minLatitude = minLatitude;
  }

  public Double getMaxLongitude() {
    return this.maxLongitude;
  }
  public void setMaxLongitude(Double maxLongitude) {
    this.maxLongitude = maxLongitude;
  }

  public Double getMinLongitude() {
    return this.minLongitude;
  }
  public void setMinLongitude(Double minLongitude) {
    this.minLongitude = minLongitude;
  }

} 