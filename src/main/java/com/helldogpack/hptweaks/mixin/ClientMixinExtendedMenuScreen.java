package com.helldogpack.hptweaks.mixin;

import com.helldogpack.hptweaks.Configuration;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.FontRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import shadows.menu.ExtendedMenuScreen;

@Mixin(ExtendedMenuScreen.class)
public class ClientMixinExtendedMenuScreen {

    @Redirect(method = "init", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/FontRenderer;getStringWidth(Ljava/lang/String;)I"))
    public int init_onGetStringWidth(FontRenderer fontRenderer, String text) {
        if (!Configuration.PACKMENU_COPYRIGHT_TEXT.get().equals("Copyright Mojang AB. Do not distribute!"))
            return fontRenderer.getStringWidth(Configuration.PACKMENU_COPYRIGHT_TEXT.get());
        return fontRenderer.getStringWidth(text);
    }
/*

    @Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/AbstractGui;drawString(Lcom/mojang/blaze3d/matrix/MatrixStack;Lnet/minecraft/client/gui/FontRenderer;Ljava/lang/String;III)V", ordinal = 2))
    public void render_onDrawString2(MatrixStack matrixStack, FontRenderer fontRenderer, String font, int text, int x, int y) {
        if (!Configuration.PACKMENU_COPYRIGHT_TEXT.get().equals("Copyright Mojang AB. Do not distribute!")) {
            ExtendedMenuScreen.drawString(matrixStack, fontRenderer, Configuration.PACKMENU_COPYRIGHT_TEXT.get(), text, x, y);
            return;
        }
        AbstractGui.drawString(matrixStack, fontRenderer, font, text, x, y);
    }
*/

}
