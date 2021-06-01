package com.cloudless.paypay.data.tflite;

import android.graphics.Bitmap;

import java.util.List;

public interface Clasiffier {
    class Recognition{
        private final String id;
        private final String name;
        private final boolean quant;
        private final Float confidance;

        public Recognition(String id, String name, boolean quant, Float confidance) {
            this.id = id;
            this.name = name;
            this.quant = quant;
            this.confidance = confidance;
        }

        public String getId(){
            return id;
        }
        public String getName(){
            return name;
        }
        public Float getConfidance(){
            return confidance;
        }

        @Override
        public String toString(){
            String hasilString = "";
            if (id != null){
                hasilString += "[" + id + "]";
            }
            if (name != null){
                hasilString += name + " ";
            }
            if(confidance != null){
                hasilString += String.format("(%.1f%%) ", confidance * 100.0f);
            }
            return id;
        }
    }
    List<Recognition> reconizeImage(Bitmap bitmap);
    void close();
}
