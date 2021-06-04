package com.example.demo5;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonManager {

    public static void main(String[] args) {
        OrgChart a = new OrgChart('b');
        OrgChart b = new OrgChart('c');
        OrgChart root = new OrgChart('a');
        root.directReports = List.of(a, b);
        getLowestCommonManager(root,a,b);
    }

    public static OrgChart getLowestCommonManager(
            OrgChart topManager,
            OrgChart reportOne,
            OrgChart reportTwo) {
        OrgChart output = new OrgChart('\u0000');
        getLCM(topManager, reportOne, null, output);
        return output;
    }

    public static int getLCM(OrgChart topManager,
                             OrgChart reportOne,
                             OrgChart reportTwo,
                             OrgChart output) {
        if (output.name != '\u0000') {
            return 2;
        }
        if (topManager == null) {
            return 0;
        }
        if (topManager == reportOne || topManager == reportTwo) {
            return 1;
        }
        int count = 0;
        for (int i = 0; i < topManager.directReports.size(); i++) {
            count += getLCM(topManager.directReports.get(i), reportOne, reportTwo, output);
        }
        if (count == 2) {
            output.name = topManager.name;
            output.directReports = topManager.directReports;
        }
        return count;
    }

    static class OrgChart {
        public char name;
        public List<OrgChart> directReports;

        OrgChart(char name) {
            this.name = name;
            this.directReports = new ArrayList<OrgChart>();
        }

        // This method is for testing only.
        public void addDirectReports(OrgChart[] directReports) {
            for (OrgChart directReport : directReports) {
                this.directReports.add(directReport);
            }
        }
    }
}
