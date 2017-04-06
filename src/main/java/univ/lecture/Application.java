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
    public Calculator calculator(String[] args) {
        Calculator calc = new Calculator();

        double result = calc.calculate(args);

        for (int i = 0; i < args.length; i++) {
			if (args[i].equals("'*'")) {
				System.out.print("* ");
			} else {
				System.out.print(args[i]+" ");
			}
		}
		System.out.println(" = "+result);

        return calc;
    }

	public static void main(String[] args) throws Exception {
        new Application().calculator(args);
	}
}
