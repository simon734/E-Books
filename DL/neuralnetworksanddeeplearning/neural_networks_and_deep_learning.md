## Chapter 1 Using neural nets to recognize handwritten digits

* Two important types of artifical neuron: perceptron and sigmoid
* The standard learning algorithm for neural networks: stochastic gradient descent.

### Perceptrons

### Sigmoid

* A small change in the weights or bias of any single perceptron in the network can sometimes cause the output of that perceptron to completely flip, say from 0 to 1. That flip may then cause the behaviour of the rest of the network to completely change in some very complicated way. That makes it difficult to see how to gradually modify the weights and biases so that the network get closer to the desired behaviour.

* The sigmoid neuron can take inputs with values between 0 and 1. The output is not 0 or 1. It's sigmoid function  $\sigma(w \cdot x + b)$:
  $$
  \sigma(z) = \frac{1}{1 + e^{-z}}
  $$

* Sigmoid function is a smoothed out perceptron. The smoothness of σ means that small changes $\Delta$wj in the weights and $\Delta$b in the bias will produce a small change $\Delta$output from the neuron:
  $$
  \Delta output = \sum_{j} \frac {\partial output} {\partial w_j} \Delta w_j +  \frac {\partial output}{\partial b} \Delta b
  $$
  ​

* dd



