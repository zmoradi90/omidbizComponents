package org.omidbiz.handler;

import java.util.Map;

import javax.faces.context.ExternalContext;

import org.omidbiz.component.UISuggestionButton;
import org.omidbiz.renderkit.html.SuggestionRendererBase;

import com.sun.facelets.FaceletContext;
import com.sun.facelets.tag.MetaRule;
import com.sun.facelets.tag.MetaRuleset;
import com.sun.facelets.tag.Metadata;
import com.sun.facelets.tag.MetadataTarget;
import com.sun.facelets.tag.TagAttribute;
import com.sun.facelets.tag.jsf.ComponentConfig;
import com.sun.facelets.tag.jsf.ComponentHandler;

public class SuggestionTagHandlerBase extends ComponentHandler
{

    public SuggestionTagHandlerBase(ComponentConfig config)
    {
        super(config);
    }

    private static final MetaRule suggestionLinkRule = new MetaRule() {

        public Metadata applyRule(String name, TagAttribute attribute, MetadataTarget meta)
        {
            if ("forceId".equals(name))
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

        private final TagAttribute forceIdAttr;

        /**
         * @param attribute
         */
        public ObjectNameMapper(TagAttribute attribute)
        {
            forceIdAttr = attribute;
        }

        /*
         * (non-Javadoc)
         * 
         * @see com.sun.facelets.tag.Metadata#applyMetadata(com.sun.facelets.
         * FaceletContext, java.lang.Object)
         */
        public void applyMetadata(FaceletContext ctx, Object instance)
        {
            UISuggestionButton sb = (UISuggestionButton) instance;
            ExternalContext external = ctx.getFacesContext().getExternalContext();
            Map requestParams = external.getRequestParameterMap();
            String forceId = (String) requestParams.get(SuggestionRendererBase.SUGGESTION_NAME_PARAM);
            if(forceId == null)
                forceId = forceIdAttr.getValue();
            if (forceId != null && forceId.trim().length() > 0)
                sb.setForceId(forceId);        
        }

    }

    protected MetaRuleset createMetaRuleset(Class type)
    {
        MetaRuleset ruleset = super.createMetaRuleset(type);
        ruleset.addRule(suggestionLinkRule);
        return ruleset;
    }
    
}
