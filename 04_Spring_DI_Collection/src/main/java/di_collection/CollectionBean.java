package di_collection;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionBean {
	private List<String> addressList; //List 타입
	private Set<String> addressSet; //Set 타입
	private Map<String, String> addressMap; //Map 타입
	private Properties addressProperties; //Map의 일종(key, value 형태로 데이터 저장)

	public CollectionBean() {
		System.out.println(">> CollectionBean() - 객체생성");
	}

	
	
	public List<String> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<String> addressList) {
		this.addressList = addressList;
	}

	
	
	public Set<String> getAddressSet() {
		return addressSet;
	}

	public void setAddressSet(Set<String> addressSet) {
		this.addressSet = addressSet;
	}
	
	
	
	public Map<String, String> getAddressMap() {
		return addressMap;
	}
	
	public void setAddressMap(Map<String, String> addressMap) {
		this.addressMap = addressMap;
	}



	public Properties getAddressProperties() {
		return addressProperties;
	}

	public void setAddressProperties(Properties addressProperties) {
		this.addressProperties = addressProperties;
	}
	
	
	
	
	
}
