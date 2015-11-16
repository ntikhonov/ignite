/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.internal.portable.streams;

/**
 * Portable output stream.
 */
public interface PortableOutputStream extends PortableStream, AutoCloseable {
    /**
     * Write byte value.
     *
     * @param val Byte value.
     */
    public void writeByte(byte val);

    /**
     * Write byte array.
     *
     * @param val Byte array.
     */
    public void writeByteArray(byte[] val);

    /**
     * Write boolean value.
     *
     * @param val Boolean value.
     */
    public void writeBoolean(boolean val);

    /**
     * Write boolean array.
     *
     * @param val Boolean array.
     */
    public void writeBooleanArray(boolean[] val);

    /**
     * Write short value.
     *
     * @param val Short value.
     */
    public void writeShort(short val);

    /**
     * Write short array.
     *
     * @param val Short array.
     */
    public void writeShortArray(short[] val);

    /**
     * Write char value.
     *
     * @param val Char value.
     */
    public void writeChar(char val);

    /**
     * Write char array.
     *
     * @param val Char array.
     */
    public void writeCharArray(char[] val);

    /**
     * Write int value.
     *
     * @param val Int value.
     */
    public void writeInt(int val);

    /**
     * Write short value at the given position.
     *
     * @param pos Position.
     * @param val Value.
     */
    public void writeShort(int pos, short val);

    /**
     * Write int value to the given position.
     *
     * @param pos Position.
     * @param val Value.
     */
    public void writeInt(int pos, int val);

    /**
     * Write int array.
     *
     * @param val Int array.
     */
    public void writeIntArray(int[] val);

    /**
     * Write float value.
     *
     * @param val Float value.
     */
    public void writeFloat(float val);

    /**
     * Write float array.
     *
     * @param val Float array.
     */
    public void writeFloatArray(float[] val);

    /**
     * Write long value.
     *
     * @param val Long value.
     */
    public void writeLong(long val);

    /**
     * Write long array.
     *
     * @param val Long array.
     */
    public void writeLongArray(long[] val);

    /**
     * Write double value.
     *
     * @param val Double value.
     */
    public void writeDouble(double val);

    /**
     * Write double array.
     *
     * @param val Double array.
     */
    public void writeDoubleArray(double[] val);

    /**
     * Write byte array.
     *
     * @param arr Array.
     * @param off Offset.
     * @param len Length.
     */
    public void write(byte[] arr, int off, int len);

    /**
     * Write data from unmanaged memory.
     *
     * @param addr Address.
     * @param cnt Count.
     */
    public void write(long addr, int cnt);

    /**
     * Close the stream releasing resources.
     */
    @Override public void close();

    /**
     * Start write in unsafe mode. Ensures there is enough data to write at least the given amount of bytes.
     *
     * @param cap Capacity.
     * @return Start position.
     */
    public int unsafeStart(int cap);

    /**
     * Finish write in unsafe mode. Essentially it just shifts position to the given location. But this method is
     * more convenient because allows for easy error detection when paired with {@link #unsafeStart(int)}.
     *
     * @param pos Final absolute position.
     */
    public void unsafeStop(int pos);

    /**
     * Write byte in unsafe mode.
     *
     * @param pos Position.
     * @param val Value.
     */
    public void unsafeWriteByte(int pos, byte val);

    /**
     * Write boolean in unsafe mode.
     *
     * @param pos Position.
     * @param val Value.
     */
    public void unsafeWriteBoolean(int pos, boolean val);

    /**
     * Write short in unsafe mode.
     *
     * @param pos Position.
     * @param val Value.
     */
    public void unsafeWriteShort(int pos, short val);

    /**
     * Write char in unsafe mode.
     *
     * @param pos Position.
     * @param val Value.
     */
    public void unsafeWriteChar(int pos, char val);

    /**
     * Write int in unsafe mode.
     *
     * @param pos Position.
     * @param val Value.
     */
    public void unsafeWriteInt(int pos, int val);

    /**
     * Write long in unsafe mode.
     *
     * @param pos Position.
     * @param val Value.
     */
    public void unsafeWriteLong(int pos, long val);

    /**
     * Write float in unsafe mode.
     *
     * @param pos Position.
     * @param val Value.
     */
    public void unsafeWriteFloat(int pos, float val);

    /**
     * Write double in unsafe mode.
     *
     * @param pos Position.
     * @param val Value.
     */
    public void unsafeWriteDouble(int pos, double val);

    /**
     * Write array in unsafe mode.
     *
     * @param pos Position.
     * @param arr Value.
     * @param off Offset.
     * @param cnt Amount of bytes to write.
     */
    public void unsafeWrite(int pos, byte[] arr, int off, int cnt);

    /**
     * Write raw memory in unsafe mode.
     *
     * @param pos Position.
     * @param addr Address.
     * @param cnt Amount of bytes to write.
     */
    public void unsafeWrite(int pos, long addr, int cnt);
}