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
  ​	$\sigma$ is commonly used in work on neural nets as the activation function.

* Sigmoid function is a smoothed out perceptron. The smoothness of σ means that small changes $\Delta$wj in the weights and $\Delta$b in the bias will produce a small change $\Delta$output from the neuron:
  $$
  \Delta output = \sum_{j} \frac {\partial output} {\partial w_j} \Delta w_j +  \frac {\partial output}{\partial b} \Delta b
  $$
  ​

* $\Delta output$ is a _linear function_ of the change $\Delta w_j$  and $\Delta b$ . This linearity makes it easy to choose small changes in the weights and biases to achieve any desired small change in the output.


### The architecture of neural networks

* The _hidden layer_ means nothing more than "not an input or an output". For historical reasons, multiple networks are sometimes called _multilayer perceptrons_ or _MLPs_, despite being made up of sigmoid neurons, not perceptrons.
* It's not possible to sum up the design process for the hidden layers with a few simple rules of thumb. Neural networks researchers have developed many design heuristics for the hidden layers. For example, such heuristics can be used to help determine how to trade off the number of hidden layers against the time required to train the network.
* _feedforword_ neural networks: the output from one layer is used as input to the next layer.
* _recurrent neural networks_ which feedback loops are possible. The idea is to have neurons which fire for some limited duration of time, before becoming quiescent. That firing can stimulate other neurons, which may fire a little while later, also for a limited duration. That causes still more neurons to fire, and so over time we get a cascade of neurons firing. Loop don't cause problems in such a model, since a neuron's output only affects its input at some later time, not instantaneously.
* The learning algorithms for recurrent nets are (at least to date) less powerful. But recurrent networks are much closer in spirit to how brains work than feedforward networks.

### A simple network to classify handwritten digits

