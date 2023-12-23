package net.shadowkat.minecraft.opensolidstate.server.drivers;

import li.cil.oc.api.driver.DriverItem;
import li.cil.oc.api.driver.item.Slot;
import li.cil.oc.api.Network;
import li.cil.oc.api.network.Environment;
import li.cil.oc.api.network.EnvironmentHost;
import li.cil.oc.api.network.Message;
import li.cil.oc.api.network.ManagedEnvironment;
import li.cil.oc.api.network.Node;
import li.cil.oc.api.network.Visibility;
import li.cil.oc.server.component.GraphicsCard;
import li.cil.oc.api.machine.Context;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.shadowkat.minecraft.opensolidstate.common.Items;
import net.shadowkat.minecraft.opensolidstate.server.components.Mux;

public class MuxDriver implements DriverItem {
    @Override
    public boolean worksWith(ItemStack stack) {
        //return false;
        //return stack.getItem().getRegistryName().equals(Items.Mux.registryName);
        return stack.getItem().getRegistryName().equals("ossm:mux");
    }
    @Override
    public ManagedEnvironment createEnvironment(ItemStack itemStack, EnvironmentHost environmentHost) {
        return new Mux();
    }
    
    @Override
    public String slot(ItemStack itemStack) {
        return Slot.Card;
    }

    @Override
    public int tier(ItemStack itemStack) {
        return 0;
    }

    @Override
    public NBTTagCompound dataTag(ItemStack stack) {
        return stack.getTagCompound().getCompoundTag("oc:data");
    }
}
