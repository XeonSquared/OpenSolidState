package net.shadowkat.minecraft.opensolidstate.common.items;

import java.util.Collections;
import kotlin.Pair;
import li.cil.oc.api.driver.DriverItem;
import li.cil.oc.api.CreativeTab;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.shadowkat.minecraft.opensolidstate.OpenSolidState;
import net.shadowkat.minecraft.opensolidstate.OssmEvents;
import net.shadowkat.minecraft.opensolidstate.common.Constants;
import net.shadowkat.minecraft.opensolidstate.common.Items;
import net.shadowkat.minecraft.opensolidstate.common.Settings;
import net.shadowkat.minecraft.opensolidstate.common.utils.Utils;
import net.shadowkat.minecraft.opensolidstate.server.drivers.MuxDriver;

import java.util.List;

public class BigIronMuxCard extends OssmBaseItem {
    public String registryName = "ossm:mux";
    public String lore = "A card designed to support multiple dumb terminals.";
    public int tier = 0;
    public void BigIronMuxCard() {
        setRegistryName("ossm:mux");
        setCreativeTab(CreativeTabs.MISC);
        li.cil.oc.api.Driver.add(new MuxDriver());
    }
    public void init() {
        setRegistryName("ossm:mux");
        setCreativeTab(CreativeTabs.MISC);
        li.cil.oc.api.Driver.add(new MuxDriver());
    }

    @Override
    public int getTier(ItemStack stack) {
        return this.tier;
    }

    @Override
    public void register(RegistryEvent.Register<Item> event) {
        this.setRegistryName("ossm:mux");
        event.getRegistry().register(this);
        li.cil.oc.api.Driver.add(new MuxDriver());
        Items.Mux = this;
        //OssmEvents.model_register.add();
    }
    @Override
    public String getLore() {
        return lore;
    }

    @Override
    public List<Pair<String, String>> getData(ItemStack stack) {
        return Collections.emptyList();
    }
}

/*
public class MuxCardDriver extends Item implements DriverItem, EnvironmentProvider {
    public MuxCardDriver() {
        setMaxDamage(0);
    }

    @Override
    public boolean worksWith(ItemStack itemStack) {
        return itemStack.getItem().equals(this)
    }

    @Override
    public ManagedEnvironment createEnvironment(ItemStack itemStack, EnvironmentHost environmentHost) {
        return new MuxEnv();
    }
    
    @Override
    public String slot(ItemStack itemStack) {
        return Slot.Card;
    }

    @Override
    public int tier(ItemStack itemStack) {
        return 1;
    }

    @Override
    public NBTTagCompound dataTag(ItemStack itemStack) {
        return OCUtils.dataTag(itemStack);
    }
}
*/
