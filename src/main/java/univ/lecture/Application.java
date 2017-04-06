/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package univ.lecture;

public class Application {
	public double calculator(String aa) {
		Calculator calc = new Calculator();

		int size = 0;
		String args[] = new String[aa.length()];
		for (int i = 0; i < aa.length(); i++) {
			args[size++] = String.valueOf(aa.charAt(i));
		}

		double result = calc.calculate(args);

		return result;
	}
}
