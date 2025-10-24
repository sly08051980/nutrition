package com.slyfly.nutrition.model.barcode


import android.content.Context
import android.util.Log
import com.google.mlkit.vision.barcode.common.Barcode
import com.google.mlkit.vision.codescanner.GmsBarcodeScannerOptions
import com.google.mlkit.vision.codescanner.GmsBarcodeScanning



class BarCodeScanner(context: Context) {
private val TAG:String = "CHECK_RESPONSE_SCANNER"
    val options = GmsBarcodeScannerOptions.Builder()
        .setBarcodeFormats(
            Barcode.FORMAT_ALL_FORMATS)
        .enableAutoZoom()
        .build()

    val scanner = GmsBarcodeScanning.getClient(context,options)

    fun startScanner(onResult: (String?) -> Unit) {
        scanner.startScan()
            .addOnSuccessListener { barcode ->
                val value=barcode.rawValue

                Log.i(TAG, onResult(value?:"null").toString())
                onResult(value)

            }
            .addOnCanceledListener {
                onResult(null)
            }
            .addOnFailureListener { e ->
                onResult(null)
            }
    }

}