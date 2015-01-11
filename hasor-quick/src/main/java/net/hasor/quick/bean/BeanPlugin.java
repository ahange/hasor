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
package net.hasor.quick.bean;
import java.util.Set;
import net.hasor.core.ApiBinder;
import net.hasor.core.Module;
import net.hasor.quick.plugin.Plugin;
import org.more.logger.LoggerHelper;
import org.more.util.ArrayUtils;
/**
 * 提供 <code>@Bean</code>注解 功能支持。
 * @version : 2013-9-13
 * @author 赵永春 (zyc@byshell.org)
 */
@Plugin
public class BeanPlugin implements Module {
    public void loadModule(ApiBinder apiBinder) throws Throwable {
        Set<Class<?>> beanSet = apiBinder.findClass(Bean.class);
        if (beanSet == null || beanSet.isEmpty())
            return;
        for (Class<?> beanClass : beanSet) {
            Bean annoBean = beanClass.getAnnotation(Bean.class);
            String[] aliasNames = annoBean.value();
            if (ArrayUtils.isEmpty(aliasNames)) {
                LoggerHelper.logWarn("missing Bean name %s", beanClass);
                continue;
            }
            //
            LoggerHelper.logInfo("loadBean %s bind %s", aliasNames, beanClass);
            String firstName = aliasNames[0];
            BeanBindingBuilder beanBinder = Beans.defineForType(apiBinder, firstName);
            for (int i = 1; i < aliasNames.length; i++) {
                beanBinder = beanBinder.aliasName(aliasNames[i]);
            }
            beanBinder.bindType(beanClass);
            //
            LoggerHelper.logFine("loadBean %s bind %s ->OK.", aliasNames, beanClass);
        }
    }
}