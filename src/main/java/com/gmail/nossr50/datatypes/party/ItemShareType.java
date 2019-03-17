package com.gmail.nossr50.datatypes.party;

import com.gmail.nossr50.config.hocon.HOCONUtil;
import com.gmail.nossr50.locale.LocaleLoader;
import com.gmail.nossr50.mcMMO;
import com.gmail.nossr50.util.ItemUtils;
import com.gmail.nossr50.util.StringUtils;
import org.bukkit.inventory.ItemStack;

public enum ItemShareType {
    LOOT,
    MINING,
    HERBALISM,
    WOODCUTTING,
    MISC;

    public static ItemShareType getShareType(ItemStack itemStack) {
        if (ItemUtils.isMobDrop(itemStack)) {
            return LOOT;
        }
        else if (ItemUtils.isMiningDrop(itemStack)) {
            return MINING;
        }
        else if (ItemUtils.isHerbalismDrop(itemStack)) {
            return HERBALISM;
        }
        else if (ItemUtils.isWoodcuttingDrop(itemStack)) {
            return WOODCUTTING;
        }
        else if (mcMMO.getConfigManager().getConfigParty().getPartyItemShare().getItemShareMap().get(HOCONUtil.serializeENUMName(itemStack.getType().toString())) != null) {
            return MISC;
        }

        return null;
    }

    public String getLocaleString() {
        return LocaleLoader.getString("Party.ItemShare.Category." + StringUtils.getCapitalized(this.toString()));
    }
}
