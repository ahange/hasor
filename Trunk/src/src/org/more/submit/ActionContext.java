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
package org.more.submit;
import java.util.Iterator;
import org.more.CastException;
import org.more.FormatException;
import org.more.NoDefinitionException;
/**
 * ���ฺ�𴴽����ҷ���{@link ActionInvoke action���ö���}��action���ö��������{@link ActionFilter action������}
 * Ҳ������Ŀ��action����ͬʱҲ������Ҳ��ҷ���action�Ĺ��������󣬴�������л�ȡaction���Ե�Ҫ��Ҳͨ���ýӿ�ʵ�֡�
 * ���һ��action�Ĺ������£�1.���ּ�� NoDefinitionException��2.Action��Ǽ��  NoDefinitionException��3.������ CastException
 * @version 2009-11-28
 * @author ������ (zyc@byshell.org)
 */
public interface ActionContext {
    /**����ĳ��Action�����Ƿ���ڣ�������Ҫ���Ե�action��������������ڷ���true���򷵻�false���÷���������������ĵ�һ�͵ڶ����ڡ�*/
    public boolean containsAction(String actionName);
    /**
     * ���Ҳ��ҷ���Ŀ��Action����findAction����������װ����action������������޷����һ��߲���action����Ŀ��ʧ���������NoDefinitionException�쳣��
     * <br/>�÷�������������������л��ڡ�
     * @param actionName action��������
     * @param invoke action�����������
     * @return ���ز��ҵ���action���ö���
     * @throws NoDefinitionException ���ּ���ڼ䷢���쳣��
     * @throws FormatException �������ڼ䷢���쳣��
     * @throws CastException ���ͼ���ڼ䷢���쳣��
     */
    public ActionInvoke findAction(String actionName, String invoke) throws NoDefinitionException, FormatException, CastException;
    /**
     * ����ActionInvoke���ö����˽�й����������û��װ��˽�й�������ԭ�����ص��ö���
     * @param actionName Ҫװ���action���������á�
     * @param invokeObject �ȴ�װ��������ĵ��ö���
     * @return ����װ���ĵ��ö���
     */
    public ActionInvoke configPrivateFilter(String actionName, ActionInvoke invokeObject);
    /**
     * ����ActionInvoke���ö���Ĺ��й����������û��װ��˽�й�������ԭ�����ص��ö���
     * @param actionName Ҫװ���action���������á�
     * @param invokeObject �ȴ�װ��������ĵ��ö���
     * @return ����װ���ĵ��ö���
     */
    public ActionInvoke configPublicFilter(String actionName, ActionInvoke invokeObject);
    /** ��ȡһ��ָ����Action���ͣ�����Ϊaction��������*/
    public Class<?> getActionType(String actionName);
    /** ͨ��������������Ե�������Action��������*/
    public Iterator<String> getActionNameIterator();
    /** ͨ��������������Ե�������Action��Դ���õ�������ɨ��ÿ��action����ķ��񷽷���*/
    public Iterator<String> getActionInvokeStringIterator();
}