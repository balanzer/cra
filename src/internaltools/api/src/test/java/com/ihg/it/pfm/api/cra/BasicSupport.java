/**
 *
 */
package com.ihg.it.pfm.api.cra;

import java.util.HashMap;
import java.util.Map;

/**
 * @author varathm
 *
 */
public class BasicSupport {

    protected static final String NAME = "name";
    protected static final String DESC = "desc";

    static Map<String, String> campaignValues = new HashMap<>();

    static {
        campaignValues.put(NAME, "UT campaign Name");
        campaignValues.put(DESC, "UT Desc");

    }
}
