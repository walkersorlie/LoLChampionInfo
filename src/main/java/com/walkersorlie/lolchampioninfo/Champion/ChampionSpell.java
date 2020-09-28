
package com.walkersorlie.lolchampioninfo.Champion;

import java.util.Objects;

/**
 *
 * @author Walker Sorlie
 */
public class ChampionSpell {
    private String id;
    private String name;
    private String description;
    private String toolTip;

    public ChampionSpell(String id, String name, String description, String toolTip) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.toolTip = toolTip;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getToolTip() {
        return toolTip;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ChampionSpell other = (ChampionSpell) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        String abilityLetter = id.substring(id.length() - 2, id.length() - 1);
        char letter = id.charAt(id.length() - 1);
        String newId = id.substring(0, id.length() - 1) + " " + letter;
        return "Champion spell" + newId + ", " + name;
    }
    
    
}
