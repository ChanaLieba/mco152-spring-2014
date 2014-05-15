package stein.triangle;

public class Triangle {
		
		int height;
		
		public Triangle(int height){
			this.height = height;
		}

		public String toString() {
			height = height - 1;
			String str = new String("");
			StringBuilder[] stringBuilderArray = new StringBuilder[height];
			StringBuilder stringBuilder = new StringBuilder("");
			StringBuilder stringBuilder2 = new StringBuilder("");
			StringBuilder stringBuilder3 = new StringBuilder("");
			for (int i = 0; i < ((height * 2) + 1); i++) {
				stringBuilder.append("*");
			}
			stringBuilderArray[height - 1] = stringBuilder;
			for (int k = (height - 1); k > 0; k--) {

				for (int j = 0; j < ((k - height) * -1); j++) {
					stringBuilder2.append(" ");
				}
				stringBuilder2.append("*");

				for (int l = 0; l < ((k * 2) - 1); l++) {
					stringBuilder2.append(" ");
				}
				stringBuilder2.append("*");

				stringBuilderArray[k - 1] = stringBuilder2;
				stringBuilder2 = new StringBuilder("");
			}
			for (int m = 0; m < height; m++) {
				str += " ";
			}
			str += "*";
			str += "\n";
			stringBuilder3.append(str);
			for (int t = 0; t < stringBuilderArray.length; t++) {
				stringBuilder3.append(stringBuilderArray[t]);
				stringBuilder3.append("\n");
			}
			return stringBuilder3.toString();
		}

	}
