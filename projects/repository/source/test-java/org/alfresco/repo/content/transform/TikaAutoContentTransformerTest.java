/*
 * #%L
 * Alfresco Repository
 * %%
 * Copyright (C) 2005 - 2016 Alfresco Software Limited
 * %%
 * This file is part of the Alfresco software. 
 * If the software was purchased under a paid Alfresco license, the terms of 
 * the paid license agreement will prevail.  Otherwise, the software is 
 * provided under the following open source license terms:
 * 
 * Alfresco is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Alfresco is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Alfresco. If not, see <http://www.gnu.org/licenses/>.
 * #L%
 */
package org.alfresco.repo.content.transform;

import org.alfresco.repo.content.MimetypeMap;
import org.alfresco.service.cmr.repository.TransformationOptions;
import org.apache.tika.config.TikaConfig;

/**
 * Most of the work for testing the Tika Auto-Detect transformer
 *  is automatically done by {@link AbstractContentTransformerTest}
 *  
 * @see org.alfresco.repo.content.transform.TikaAutoContentTransformer
 * 
 * @author Nick Burch
 */
public class TikaAutoContentTransformerTest extends TikaPoweredContentTransformerTest
{
    private TikaAutoContentTransformer transformer;
    
    @Override
    public void setUp() throws Exception
    {
        super.setUp();
        
        TikaConfig config = (TikaConfig)ctx.getBean("tikaConfig");
        transformer = new TikaAutoContentTransformer( config );
        transformer.setMimetypeService(mimetypeService);
        transformer.setTransformerDebug(transformerDebug);
        transformer.setTransformerConfig(transformerConfig);
    }
    
    /**
     * @return Returns the same transformer regardless - it is allowed
     */
    protected ContentTransformer getTransformer(String sourceMimetype, String targetMimetype)
    {
        return transformer;
    }
    
    /**
     * Ensure we picked up a mixture of content
     *  types from Tika
     */
    public void testIsTransformable() throws Exception
    {
        // Excel (but this isn't normally used)
        assertFalse(transformer.isTransformable(MimetypeMap.MIMETYPE_TEXT_PLAIN, -1, MimetypeMap.MIMETYPE_EXCEL, new TransformationOptions()));
        assertTrue(transformer.isTransformable(MimetypeMap.MIMETYPE_EXCEL, -1, MimetypeMap.MIMETYPE_TEXT_PLAIN, new TransformationOptions()));
        assertTrue(transformer.isTransformable(MimetypeMap.MIMETYPE_EXCEL, -1, MimetypeMap.MIMETYPE_HTML, new TransformationOptions()));
        assertTrue(transformer.isTransformable(MimetypeMap.MIMETYPE_EXCEL, -1, MimetypeMap.MIMETYPE_XML, new TransformationOptions()));
        
        // Word
        assertFalse(transformer.isTransformable(MimetypeMap.MIMETYPE_TEXT_PLAIN, -1, MimetypeMap.MIMETYPE_WORD, new TransformationOptions()));
        assertTrue(transformer.isTransformable(MimetypeMap.MIMETYPE_WORD, -1, MimetypeMap.MIMETYPE_TEXT_PLAIN, new TransformationOptions()));
        assertTrue(transformer.isTransformable(MimetypeMap.MIMETYPE_WORD, -1, MimetypeMap.MIMETYPE_HTML, new TransformationOptions()));
        assertTrue(transformer.isTransformable(MimetypeMap.MIMETYPE_WORD, -1, MimetypeMap.MIMETYPE_XML, new TransformationOptions()));
        
        // PDF
        assertFalse(transformer.isTransformable(MimetypeMap.MIMETYPE_TEXT_PLAIN, -1, MimetypeMap.MIMETYPE_PDF, new TransformationOptions()));
        assertTrue(transformer.isTransformable(MimetypeMap.MIMETYPE_PDF, -1, MimetypeMap.MIMETYPE_TEXT_PLAIN, new TransformationOptions()));
        assertTrue(transformer.isTransformable(MimetypeMap.MIMETYPE_PDF, -1, MimetypeMap.MIMETYPE_HTML, new TransformationOptions()));
        assertTrue(transformer.isTransformable(MimetypeMap.MIMETYPE_PDF, -1, MimetypeMap.MIMETYPE_XML, new TransformationOptions()));
        
        // Open Office
        assertFalse(transformer.isTransformable(MimetypeMap.MIMETYPE_TEXT_PLAIN, -1, MimetypeMap.MIMETYPE_OPENDOCUMENT_PRESENTATION, new TransformationOptions()));
        assertTrue(transformer.isTransformable(MimetypeMap.MIMETYPE_OPENDOCUMENT_PRESENTATION, -1, MimetypeMap.MIMETYPE_TEXT_PLAIN, new TransformationOptions()));
        assertTrue(transformer.isTransformable(MimetypeMap.MIMETYPE_OPENDOCUMENT_PRESENTATION, -1, MimetypeMap.MIMETYPE_HTML, new TransformationOptions()));
        assertTrue(transformer.isTransformable(MimetypeMap.MIMETYPE_OPENDOCUMENT_PRESENTATION, -1, MimetypeMap.MIMETYPE_XML, new TransformationOptions()));
        
        // We don't do images
        assertFalse(transformer.isTransformable(MimetypeMap.MIMETYPE_IMAGE_JPEG, -1, MimetypeMap.MIMETYPE_TEXT_PLAIN, new TransformationOptions()));
        assertFalse(transformer.isTransformable(MimetypeMap.MIMETYPE_IMAGE_JPEG, -1, MimetypeMap.MIMETYPE_HTML, new TransformationOptions()));
        assertFalse(transformer.isTransformable(MimetypeMap.MIMETYPE_IMAGE_JPEG, -1, MimetypeMap.MIMETYPE_XML, new TransformationOptions()));
        // Ditto music
        assertFalse(transformer.isTransformable(MimetypeMap.MIMETYPE_MP3, -1, MimetypeMap.MIMETYPE_TEXT_PLAIN, new TransformationOptions()));
        assertFalse(transformer.isTransformable(MimetypeMap.MIMETYPE_MP3, -1, MimetypeMap.MIMETYPE_HTML, new TransformationOptions()));
        assertFalse(transformer.isTransformable(MimetypeMap.MIMETYPE_MP3, -1, MimetypeMap.MIMETYPE_XML, new TransformationOptions()));
    }
}
