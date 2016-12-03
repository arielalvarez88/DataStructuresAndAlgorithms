
package com.ariel.data_structures;

public class CustomStringBuffer {

	public String name = "";
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof CustomStringBuffer)) {
			return false;
		}
		return this.toString() == obj.toString();
	}

}
