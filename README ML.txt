Requirements

Python 3.7.10

Tensorflow 1.14.0

Keras 2.3.1
Scikit-learn 0.23.2
Numpy 1.16.4

Matplotlib

 3.1.2

Dataset

Training: Use 1200 self-taken photos at home from mobile phone for 4 classes (300 photos per class)
Validation: Use 800 self-taken photos at local stores from mobile phone for 4 classes (200 photos per class)



Data Augmentation

Training: Use augmentation to increase training data variability with rescale 1/255, sheer range 0.2, zoom range 0.2, horizontal flip true, 
Validation: Use augmentation to match with training data scale with rescale 1/255



Setup

Random seed: Set random seed number at any value to make sure the reproducability of the model

Callback: Set callback at 90% validation accuracy to as early trainig stop to avoid overfitting due to a relatively easy training and validation data for this project



Model Architecture

Pre-trained model: Choose MobileNetV2 as pre-trained model because its relatively low in size and suitable for this kind of data
Added layers

: Add Global Average Pooling 2D, Dropout layer, Dense layer, and Output layer after the last layer of MobileNetV2

Model Fit

Optimizer: Adam optimizer

Loss function

: Sparse Categorical Crossentropy

Hyperparameter

Epoch: Set for 10 epochs

Batch size: Set batch size number to be 40 as a balanced size to avoid overfitting and underfitting
Dropout

 rate: Set dropout rate to be 0.5 to avoid overfitting and underfitting

Evaluation

Metrics: Use maximum inference time of 0.5 second and 90% validation accuracy
 as the metrics to choose what model to use

Classification report: Use scikit-learn classification report to help evaluate 

what class is performing better or worse than the other to improve specifically
Saving
: Save in either Keras HD5 format or Tensorflow SavedModel format

Convert model: 
Convert the saved model to Tensorflow Lite with or without quantization to be deployed in Android