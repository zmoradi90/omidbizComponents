/*******************************************************************************
 * Copyright 2012 Omid Pourhadi
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.omidbiz.handler;

import java.util.Map;

import javax.el.ValueExpression;
import javax.faces.context.ExternalContext;

import org.omidbiz.component.UIInputListOfValues;

import com.sun.facelets.FaceletContext;
import com.sun.facelets.tag.MetaRule;
import com.sun.facelets.tag.MetaRuleset;
import com.sun.facelets.tag.Metadata;
import com.sun.facelets.tag.MetadataTarget;
import com.sun.facelets.tag.TagAttribute;
import com.sun.facelets.tag.jsf.ComponentConfig;
import com.sun.facelets.tag.jsf.ComponentHandler;

/**
 * 
 * @author Omid Pourhadi
 * @version $Revision: 1.0
 * 
 */
public class LovTagHandlerBase extends ComponentHandler
{

    public LovTagHandlerBase(ComponentConfig config)
    {
        super(config);
    }

    private static final MetaRule lovLinkRule = new MetaRule() {

        public Metadata applyRule(String name, TagAttribute attribute, MetadataTarget meta)
        {
            if ("objectName".equals(name))
            {
                return new ObjectNameMapper(attribute);
            }
            else
            {
                return null;
            }
        }

    };

    private static final class ObjectNameMapper extends Metadata
    {

        private final TagAttribute objectNameAttr;

        /**
         * @param attribute
         */
        public ObjectNameMapper(TagAttribute attribute)
        {
            objectNameAttr = attribute;
        }

        /*
         * (non-Javadoc)
         * 
         * @see com.sun.facelets.tag.Metadata#applyMetadata(com.sun.facelets.
         * FaceletContext, java.lang.Object)
         */
        public void applyMetadata(FaceletContext ctx, Object instance)
        {
            UIInputListOfValues lov = (UIInputListOfValues) instance;
            ExternalContext external = ctx.getFacesContext().getExternalContext();
            Map requestParams = external.getRequestParameterMap();
            String objectName = (String) requestParams.get("objectName");
            if(objectName == null)
                objectName = objectNameAttr.getValue();
            if (objectName != null && objectName.trim().length() > 0)
                lov.setObjectName(objectName);        
        }

    }

    protected MetaRuleset createMetaRuleset(Class type)
    {
        MetaRuleset ruleset = super.createMetaRuleset(type);
        ruleset.addRule(lovLinkRule);
        return ruleset;
    }

}
