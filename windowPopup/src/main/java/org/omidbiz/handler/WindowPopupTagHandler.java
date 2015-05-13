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

import org.ajax4jsf.webapp.taglib.AjaxComponentHandler;
import org.omidbiz.component.UIWindowPopup;

import com.sun.facelets.FaceletContext;
import com.sun.facelets.tag.MetaRule;
import com.sun.facelets.tag.MetaRuleset;
import com.sun.facelets.tag.Metadata;
import com.sun.facelets.tag.MetadataTarget;
import com.sun.facelets.tag.MethodRule;
import com.sun.facelets.tag.TagAttribute;
import com.sun.facelets.tag.jsf.ComponentConfig;

/**
 * 
 * @author Omid Pourhadi
 * @version $Revision: 1.0
 * 
 */
public class WindowPopupTagHandler extends AjaxComponentHandler
{

    private static final WindowPopupTagHandlerMetaRule metaRule =
            new WindowPopupTagHandlerMetaRule();
    
	public WindowPopupTagHandler(ComponentConfig config)
	{
		super(config);
	}

	@Override
	protected MetaRuleset createMetaRuleset(Class type)
	{
	    MetaRuleset metaRuleset = super.createMetaRuleset(type);
	    metaRuleset.addRule(metaRule);
		return metaRuleset;
	}
	
	static class WindowPopupTagHandlerMetaRule extends MetaRule {

        /**
         * Apply rule.
         *
         * @param name rule name
         * @param attribute {@link com.sun.facelets.tag.TagAttribute}
         * @param meta {@link com.sun.facelets.tag.TagAttribute}
         * @return metadata {@link com.sun.facelets.tag.Metadata}
         *
         * @see {@link com.sun.facelets.tag.MetaRule#applyRule(String,
         *      com.sun.facelets.tag.TagAttribute,
         *      com.sun.facelets.tag.MetadataTarget)}
         */
        public Metadata applyRule(final String name,
                                  final TagAttribute attribute,
                                  final MetadataTarget meta) {
            if (meta.isTargetInstanceOf(UIWindowPopup.class)) {
                if ("atClose".equals(name)) {
                    return new WindowPopupActionMapper(attribute);
                }

            }
            return null;
        }

        
    }
	
	/**
     * Meta data implementation.
     */
    static class WindowPopupActionMapper extends Metadata {
        /**
         * Signature.
         */
        private static final Class[] SIGNATURE =
                new Class[]{};

        /**
         * Action attribute.
         */
        private final TagAttribute action;

        /**
         * Sets attribute.
         *
         * @param attribute {@link com.sun.facelets.tag.TagAttribute}
         */
        public WindowPopupActionMapper(final TagAttribute attribute) {
            action = attribute;
        }

        /**
         * Apply metadata.

         * @param context {@link javax.faces.context.FacesContext}
         * @param instance {@link java.lang.Object}
         *
         * @see {@link com.sun.facelets.tag.Metadata#applyMetadata(
         *      com.sun.facelets.FaceletContext, Object)}
         */
        public void applyMetadata(final FaceletContext context,
                                  final Object instance) {
            ((UIWindowPopup) instance)
                    .setAtCloseAction(this.action
                            .getMethodExpression(context, null, SIGNATURE));
        }
    }

}
