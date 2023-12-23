package net.shadowkat.minecraft.opensolidstate.server.components;

import li.cil.oc.api.Network;
import li.cil.oc.api.network.Environment;
import li.cil.oc.api.network.ManagedEnvironment;
import li.cil.oc.api.network.Message;
import li.cil.oc.api.network.Node;
import li.cil.oc.api.network.Visibility;
import li.cil.oc.server.component.GraphicsCard;
import li.cil.oc.api.machine.Context;
import net.minecraft.nbt.NBTTagCompound;

public class Mux implements ManagedEnvironment{
    private static int tier = 2;
    private static GraphicsCard[] gpus = new GraphicsCard[4];
    @Override
    public Node node() {
        for (int i = 0; i < gpus.length; i++) {
            gpus[i] = new GraphicsCard(tier-1);
        }
        return Network.newNode(gpus[0], Visibility.Network).withComponent("gpu").withConnector().create();
    };
    @Override
    public void onConnect(Node node) {
        System.out.println("test");
        if (node.host() instanceof Context) {
            for (int i = 1; i < gpus.length; i++) {
                node.connect(gpus[i].node());
            }
        }
    }
    @Override
    public void onDisconnect(Node node) {
        System.out.println("test");
        if (node.host() instanceof Context) {
            for (int i = 1; i < gpus.length; i++) {
                node.disconnect(gpus[i].node());
            }
        }
    };
    @Override
    public void onMessage(Message message) {
        return;
    };
    @Override
    public void update() {
        return;
    }
    @Override
    public boolean canUpdate() {
        return false;
    }
    @Override
    public void save(NBTTagCompound nbt) {
        return;
    }
    @Override
    public void load(NBTTagCompound nbt) {
        return;
    }
    /*
    */
}
