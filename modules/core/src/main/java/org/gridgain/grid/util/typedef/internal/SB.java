/* @java.file.header */

/*  _________        _____ __________________        _____
 *  __  ____/___________(_)______  /__  ____/______ ____(_)_______
 *  _  / __  __  ___/__  / _  __  / _  / __  _  __ `/__  / __  __ \
 *  / /_/ /  _  /    _  /  / /_/ /  / /_/ /  / /_/ / _  /  _  / / /
 *  \____/   /_/     /_/   \_,__/   \____/   \__,_/  /_/   /_/ /_/
 */

package org.gridgain.grid.util.typedef.internal;

import org.gridgain.grid.util.*;

/**
 * Defines internal {@code typedef} for {@link GridStringBuilder}. Since Java doesn't provide type aliases
 * (like Scala, for example) we resort to these types of measures. This is intended for internal
 * use only and meant to provide for more terse code when readability of code is not compromised.
 */
public class SB extends GridStringBuilder {
    /** */
    private static final long serialVersionUID = 0L;


    /**
     * @see GridStringBuilder#GridStringBuilder()
     */
    public SB() {
        super(16);
    }

    /**
     *
     * @param cap Capacity.
     * @see GridStringBuilder#GridStringBuilder(int)
     */
    public SB(int cap) {
        super(cap);
    }

    /**
     *
     * @param str String.
     * @see GridStringBuilder#GridStringBuilder(String)
     */
    public SB(String str) {
        super(str);
    }

    /**
     * @param seq Sequence.
     * @see GridStringBuilder#GridStringBuilder(CharSequence)
     */
    public SB(CharSequence seq) {
        super(seq);
    }
}
