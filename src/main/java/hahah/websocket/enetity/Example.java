package hahah.websocket.enetity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Setter(value = AccessLevel.PRIVATE)
public class Example {

	private String value1;
	private String value2;
	
	public void updateEntity(Example updateData) {
		if (updateData.getValue1() != null ) {
			updateData.setValue1(updateData.getValue1());
		}
		if (updateData.getValue2() != null) {
			updateData.setValue2(updateData.getValue2());
		}
	}
}
