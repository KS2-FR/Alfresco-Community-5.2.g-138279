/*
 * #%L
 * Alfresco Solr Client
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
package org.alfresco.solr;

/**
 * @author Andy
 *
 */
public class AclReport
{

    private Long aclId;
    
    private boolean existsInDb;
    
    private Long indexAclDoc;
    
    private Long indexAclTx;
    private Long indexedAclDocCount;

    /**
     * @return the aclId
     */
    public Long getAclId()
    {
        return aclId;
    }

    /**
     * @param aclId the aclId to set
     */
    public void setAclId(Long aclId)
    {
        this.aclId = aclId;
    }

    /**
     * @return the existsInDb
     */
    public boolean isExistsInDb()
    {
        return existsInDb;
    }

    /**
     * @param existsInDb the existsInDb to set
     */
    public void setExistsInDb(boolean existsInDb)
    {
        this.existsInDb = existsInDb;
    }

    /**
     * @return the indexAclDoc
     */
    public Long getIndexAclDoc()
    {
        return indexAclDoc;
    }

    /**
     * @param indexAclDoc the indexAclDoc to set
     */
    public void setIndexAclDoc(Long indexAclDoc)
    {
        this.indexAclDoc = indexAclDoc;
    }

    /**
     * @return the indexAclTx
     */
    public Long getIndexAclTx()
    {
        return indexAclTx;
    }

    /**
     * @param indexAclTx the indexAclTx to set
     */
    public void setIndexAclTx(Long indexAclTx)
    {
        this.indexAclTx = indexAclTx;
    }

    public Long getIndexedAclDocCount()
    {
        return indexedAclDocCount;
    }

    public void setIndexedAclDocCount(Long indexedAclDocCount)
    {
        this.indexedAclDocCount = indexedAclDocCount;
    }
}
