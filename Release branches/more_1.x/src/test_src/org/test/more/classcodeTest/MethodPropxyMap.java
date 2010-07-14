/*
 * Copyright 2008-2009 the original author or authors.
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
package org.test.more.classcodeTest;
/*
 * 1.����This�������ø���
 * 2.��д���е�ǰ�෽��
 * 3.������п�����д�ķ���
 * 
 */
@SuppressWarnings("serial")
public class MethodPropxyMap implements java.io.Serializable {
    public void aaa() {
        this.a();
    }
    protected long a() {
        long j = 0;
        for (int i = 0; i < 10000; i++)
            j = j * i;
        return j;
    }
}