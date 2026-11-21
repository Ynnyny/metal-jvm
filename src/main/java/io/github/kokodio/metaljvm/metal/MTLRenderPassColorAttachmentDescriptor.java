package io.github.kokodio.metaljvm.metal;

import io.github.kokodio.metaljvm.objc.NativeStack;
import io.github.kokodio.metaljvm.objc.ObjC;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;

import static java.lang.foreign.ValueLayout.ADDRESS;
import static java.lang.foreign.ValueLayout.JAVA_LONG;

/**
 * {@code MTLRenderPassColorAttachmentDescriptor}
 *
 * @see <a href="https://developer.apple.com/documentation/metal/mtlrenderpasscolorattachmentdescriptor">Apple documentation</a>
 */
public class MTLRenderPassColorAttachmentDescriptor extends MTLRenderPassAttachmentDescriptor {
    private static final SymbolLookup FRAMEWORK = ObjC.framework("Metal");
    private static final long CLS = ObjC.clazz("MTLRenderPassColorAttachmentDescriptor");
    private static final long SEL_clearColor = ObjC.selector("clearColor");
    private static final MethodHandle MH_clearColor = ObjC.msgSendCritical(FunctionDescriptor.of(MTLClearColor.LAYOUT, JAVA_LONG, JAVA_LONG));
    private static final MethodHandle MH_clearColorStret = ObjC.hasMsgSendStret()
            ? ObjC.msgSendStret(FunctionDescriptor.ofVoid(ADDRESS, JAVA_LONG, JAVA_LONG))
            : null;
    private static final long SEL_setClearColor_ = ObjC.selector("setClearColor:");
    private static final MethodHandle MH_setClearColor_ = ObjC.msgSendCritical(FunctionDescriptor.ofVoid(JAVA_LONG, JAVA_LONG, MTLClearColor.LAYOUT));
    private static final long SEL_alloc = ObjC.selector("alloc");
    private static final MethodHandle MH_alloc = ObjC.msgSendCritical(FunctionDescriptor.of(JAVA_LONG, JAVA_LONG, JAVA_LONG));
    private static final long SEL_init = ObjC.selector("init");

    public MTLRenderPassColorAttachmentDescriptor(final long handle) {
        super(handle);
    }

    /**
     * {@code +[MTLRenderPassColorAttachmentDescriptor alloc]}
     * <p>Returns a retained (+1) object that still has to be initialized.
     */
    public static MTLRenderPassColorAttachmentDescriptor alloc() {
        try {
            return new MTLRenderPassColorAttachmentDescriptor((long) MH_alloc.invokeExact(CLS, SEL_alloc));
        } catch (Throwable throwable) {
            throw new AssertionError(throwable);
        }
    }

    /** {@code -[MTLRenderPassColorAttachmentDescriptor init]} */
    public MTLRenderPassColorAttachmentDescriptor init() {
        try {
            this.handle = (long) MH_alloc.invokeExact(this.handle, SEL_init);
            return this;
        } catch (Throwable throwable) {
            throw new AssertionError(throwable);
        }
    }

    /** {@code -[MTLRenderPassColorAttachmentDescriptor clearColor]} */
    public MTLClearColor clearColor() {
        try (NativeStack stack = NativeStack.push()) {
            if (ObjC.hasMsgSendStret()) {
                MemorySegment result = stack.allocate(MTLClearColor.LAYOUT);
                MH_clearColorStret.invokeExact(result, this.handle, SEL_clearColor);
                return MTLClearColor.read(result);
            }
            return MTLClearColor.read((MemorySegment) MH_clearColor.invokeExact((SegmentAllocator) stack, this.handle, SEL_clearColor));
        } catch (Throwable throwable) {
            throw new AssertionError(throwable);
        }
    }

    /** {@code -[MTLRenderPassColorAttachmentDescriptor setClearColor:]} */
    public void setClearColor(final MTLClearColor clearColor) {
        try (NativeStack stack = NativeStack.push()) {
            MH_setClearColor_.invokeExact(this.handle, SEL_setClearColor_, clearColor.on(stack));
        } catch (Throwable throwable) {
            throw new AssertionError(throwable);
        }
    }
}
