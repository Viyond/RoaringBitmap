package org.roaringbitmap.realdata.wrapper;

import com.googlecode.javaewah.EWAHCompressedBitmap;

import java.io.DataOutputStream;
import java.io.IOException;

final class EwahBitmapWrapper implements Bitmap {

   private final EWAHCompressedBitmap bitmap;

   EwahBitmapWrapper(EWAHCompressedBitmap bitmap) {
      this.bitmap = bitmap;
   }

   @Override
   public boolean contains(int i) {
      return bitmap.get(i);
   }

   @Override
   public int last() {
      return bitmap.reverseIntIterator().next();
   }

   @Override
   public int cardinality() {
      return bitmap.cardinality();
   }

   @Override
   public Bitmap and(Bitmap other) {
      return new EwahBitmapWrapper(bitmap.and(((EwahBitmapWrapper)other).bitmap));
   }

   @Override
   public void serialize(DataOutputStream dos) throws IOException {
      bitmap.serialize(dos);
   }

}
