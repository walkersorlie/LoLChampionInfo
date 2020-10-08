/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.walkersorlie.lolchampioninfo.Champion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

public enum MultiNameChampionsEnum {
    AURELIONSOL {
        private final ArrayList<String> aliases = new ArrayList(Arrays.asList("asol"));
        
        @Override
        public String formatNameForUrl() {
            return "AurelionSol.json";
        }

        @Override
        public ArrayList<String> getAliases() {
            return aliases;
        }

        @Override
        public String formatNameForTable() {
            return "AurelionSol";
        }
    },
    DRMUNDO {
        private final ArrayList<String> aliases = new ArrayList(Arrays.asList("mundo"));
        
        @Override
        public String formatNameForUrl() {
            return "DrMundo.json";
        }

        @Override
        public ArrayList<String> getAliases() {
            return aliases;
        }

        @Override
        public String formatNameForTable() {
            return "DrMundo";
        }
    },
    JARVANIV {
        private final ArrayList<String> aliases = new ArrayList(Arrays.asList("j4"));
        
        @Override
        public String formatNameForUrl() {
            return "JarvanIV.json";
        }

        @Override
        public ArrayList<String> getAliases() {
            return aliases;
        }

        @Override
        public String formatNameForTable() {
            return "JarvanIV";
        }
    },
    KOGMAW {
        private final ArrayList<String> aliases = new ArrayList(Arrays.asList("kog"));
        
        @Override
        public String formatNameForUrl() {
            return "KogMaw.json";
        }

        @Override
        public ArrayList<String> getAliases() {
            return aliases;
        }

        @Override
        public String formatNameForTable() {
            return "KogMaw";
        }
    },
    LEESIN {
        private final ArrayList<String> aliases = new ArrayList(Arrays.asList("lee"));
        
        @Override
        public String formatNameForUrl() {
            return "LeeSin.json";
        }

        @Override
        public ArrayList<String> getAliases() {
            return aliases;
        }

        @Override
        public String formatNameForTable() {
            return "LeeSin";
        }
    },
    MASTERYI {
        private final ArrayList<String> aliases = new ArrayList(Arrays.asList("yi"));
        
        @Override
        public String formatNameForUrl() {
            return "MasterYi.json";
        }

        @Override
        public ArrayList<String> getAliases() {
            return aliases;
        }

        @Override
        public String formatNameForTable() {
            return "MasterYi";
        }
    },
    MISSFORTUNE {
        private final ArrayList<String> aliases = new ArrayList(Arrays.asList("mf"));
        
        @Override
        public String formatNameForUrl() {
            return "MissFortune.json";
        }

        @Override
        public ArrayList<String> getAliases() {
            return aliases;
        }

        @Override
        public String formatNameForTable() {
            return "MissFortune";
        }
    },
    MONKEYKING {
        private final ArrayList<String> aliases = new ArrayList(Arrays.asList("wu", "wukong"));
        
        @Override
        public String formatNameForUrl() {
            return "MonkeyKing.json";
        }

        @Override
        public ArrayList<String> getAliases() {
            return aliases;
        }

        @Override
        public String formatNameForTable() {
            return "MonkeyKing";
        }
    },
    REKSAI {
        private final ArrayList<String> aliases = new ArrayList(Arrays.asList("reksai"));
        
        @Override
        public String formatNameForUrl() {
            return "RekSai.json";
        }

        @Override
        public ArrayList<String> getAliases() {
            return aliases;
        }

        @Override
        public String formatNameForTable() {
            return "RekSai";
        }
    },
    TAHMKENCH {
        private final ArrayList<String> aliases = new ArrayList(Arrays.asList("tk", "kench"));
        
        @Override
        public String formatNameForUrl() {
            return "TahmKench.json";
        }

        @Override
        public ArrayList<String> getAliases() {
            return aliases;
        }

        @Override
        public String formatNameForTable() {
            return "TahmKench";
        }
    },
    TWISTEDFATE {
        private final ArrayList<String> aliases = new ArrayList(Arrays.asList("tf"));
        
        @Override
        public String formatNameForUrl() {
            return "TwistedFate.json";
        }

        @Override
        public ArrayList<String> getAliases() {
            return aliases;
        }

        @Override
        public String formatNameForTable() {
            return "TwistedFate";
        }
    },
    XINZHAO {
        private final ArrayList<String> aliases = new ArrayList(Arrays.asList("xin"));
        
        @Override
        public String formatNameForUrl() {
            return "XinZhao.json";
        }

        @Override
        public ArrayList<String> getAliases() {
            return aliases;
        }

        @Override
        public String formatNameForTable() {
            return "XinZhao";
        }
    };
    
    public abstract String formatNameForTable();
    public abstract String formatNameForUrl();
    public abstract ArrayList<String> getAliases();
    
    public static final EnumMap MULTI_NAME_CHAMPIONS_ENUM_MAP = new EnumMap(MultiNameChampionsEnum.class) {
        {
            put(MultiNameChampionsEnum.AURELIONSOL, MultiNameChampionsEnum.AURELIONSOL.getAliases());     
            put(MultiNameChampionsEnum.DRMUNDO, MultiNameChampionsEnum.DRMUNDO.getAliases());
            put(MultiNameChampionsEnum.JARVANIV, MultiNameChampionsEnum.JARVANIV.getAliases());
            put(MultiNameChampionsEnum.KOGMAW, MultiNameChampionsEnum.KOGMAW.getAliases());
            put(MultiNameChampionsEnum.LEESIN, MultiNameChampionsEnum.LEESIN.getAliases());
            put(MultiNameChampionsEnum.MASTERYI, MultiNameChampionsEnum.MASTERYI.getAliases());
            put(MultiNameChampionsEnum.MISSFORTUNE, MultiNameChampionsEnum.MISSFORTUNE.getAliases());
            put(MultiNameChampionsEnum.MONKEYKING, MultiNameChampionsEnum.MONKEYKING.getAliases());
            put(MultiNameChampionsEnum.REKSAI, MultiNameChampionsEnum.REKSAI.getAliases());
            put(MultiNameChampionsEnum.TAHMKENCH, MultiNameChampionsEnum.TAHMKENCH.getAliases());
            put(MultiNameChampionsEnum.TWISTEDFATE, MultiNameChampionsEnum.TWISTEDFATE.getAliases());
            put(MultiNameChampionsEnum.XINZHAO, MultiNameChampionsEnum.XINZHAO.getAliases());
        }
    };
    
    public static String checkNameAndAliases(String name, boolean forUrl) {
        String formattedName = name.trim();
        try {
            /**
             * Check if passed champion name is one of the enum constants
             */
            MultiNameChampionsEnum enumName = MultiNameChampionsEnum.valueOf(formattedName.toUpperCase());
            if (MULTI_NAME_CHAMPIONS_ENUM_MAP.containsKey(enumName)) {
                if(forUrl)
                    return enumName.formatNameForUrl();
                else
                    return enumName.formatNameForTable();
            }
        } catch (IllegalArgumentException ex) {
            /**
             * Check the alias lists for the passed champion name
             */
            Iterator<Map.Entry<MultiNameChampionsEnum, ArrayList<String>>> entrySet = MULTI_NAME_CHAMPIONS_ENUM_MAP.entrySet().iterator();
            while (entrySet.hasNext()) {
                Map.Entry<MultiNameChampionsEnum, ArrayList<String>> entry = entrySet.next();
                if (entry.getValue().contains(formattedName.toLowerCase())) {
                    if(forUrl)
                        return entry.getKey().formatNameForUrl();
                    else
                        return entry.getKey().formatNameForTable();
                }
            }
        }
        /**
         * Passed champion name is neither an enum constant nor an alias for an enum constant
         */
        formattedName = formattedName.substring(0, 1).toUpperCase() + formattedName.substring(1).toLowerCase(); 
        if(forUrl)
            return formattedName + ".json";
        else
            return formattedName;
    }
}
