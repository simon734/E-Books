## Chapter 1 Using neural nets to recognize handwritten digits

* Two important types of artifical neuron: perceptron and sigmoid
* The standard learning algorithm for neural networks: stochastic gradient descent.

### Perceptrons

1. In much modern work on neural networks, the main neuron model used is one called the __sigmoid__ neuron.

2. A perceptron can weigh up different kinks of evidence in order to make decisions.

3. The **perceptron** is an algorithm for **supervised learning** of **binary classifiers** (functions that can decide whether an input, represented by a vector of numbers, belongs to some specific class or not):
   $$
   f(x) =
     \begin{cases}
       1       & \quad \text{if } w \cdot x \text{ + b > 0}\\
       0  	   & \quad  \text{ otherwise}
     \end{cases}
   $$
   ​						where w is a vector of real-valued weights.

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

### Learning with gradient descent

* _cost function_ :
  $$
  C(w, b) = \frac {1}{2n} \sum_x ||y(x) - a||^2
  $$
  We'll call $C$ the _quadratic_ cost function; it's also known as the _mean squared error_ or just *MSE*.

  For $C(v), v=(v_1, v_2,...)$,  calculus tells us that $C$ changes as follows:
  $$
  \Delta C \approx \frac {\partial C} {\partial v_1}\Delta v_1 + \frac {\partial C}{\partial v_2}\Delta v_2
  $$

* It helps to define:
  $$
  \Delta v \equiv (\Delta v_1,  \Delta v_2)^T
  $$

  $$
  \nabla C \equiv (\frac {\partial C}{\partial v_1}, \frac {\partial C}{\partial v_2})^T
  $$

  With these, $\Delta C$  can be rewritten as:
  $$
  \Delta C \approx \nabla C \cdot \Delta v
  $$
  The gradient vector $\nabla C$ relates changes in $v$ to changes in $C$.

* Suppose $\Delta v = -\eta \nabla C$, where $\eta$ is a small, positive *learning rate*, then we have $\Delta C \approx -\eta\nabla C \cdot \nabla C = -\eta ||\nabla C||^2$ ,  which is:
  $$
  v \to v^{\prime} = v - \eta \nabla C
  $$
  The way the gradient descent algorithm works is to repeatedly compute the gradient $\nabla C$.
  $$
  w_k \to w_k^{\prime} = w_k - \frac{\eta}{m} \sum_j \frac{\part C_{X_j}}{\part w_k}
  $$

  $$
  b_k \to b_k^{\prime} = b_k - \frac{\eta}{m} \sum_j \frac{\part C_{X_j}}{\part b_k}
  $$

* Gradient descent can be viewed as a way of taking small steps in the direction which does the most to immediately decrease $C$.

* _Stochastic gradient descent_ works by randomly picking out a small number $m$ of randomly chose training inputs, and refer to them as a _mini-batch_. Provided the sample size $m$ is large enough we expect that the average value of the $\nabla C_{X_j}$ will be roughly equal to the average over all $\nabla C_x$, that is, 
  $$
  \frac{\sum_{j=1}^{m} \nabla C_{X_j}}{m} \approx \frac{\sum_x \nabla C_x}{n} = \nabla C
  $$

* When we've exhausted the training input, which is  said to complete an _epoch_ of training, we start over with a new training epoch.

* The estimate won't be perfect-there will be statistical fluctuations- but it doesn't need to be perfect: all we really care about is moving in a general direction that will help decrease $C$, and that means we don't need an exact computation of the gradient. In practice, stochastic gradient descent is a commonly used and powerful technique for learning in neural networks.

* An extreme version of gradient descent is to use a mini-batch size of just 1. This procedure is known as _online_, _on-line_, or _incremental learning_.

###Implementing our network to classify digits

* ..


##Chapter 2: How the backpropagation algorithm works

* Today, the backpropagation algorithm is the workhorse of learning in neural networks.

### Warm up: a fast matrix-based approach to computing the output from a neural network

* We'll use $w_{jk}^l$ to denote the weight for the connection from the $k^{th}$ neuron in the $(l - 1)^{th}$ layer to the $j^{th}$ neuron in the $l^{th}$ layer. Similarly, we use $b_j^l$ for the bias of the $j^{th}$ neuron in the $l^{th}$ layer, as $a_j^l$.

  ![img](http://neuralnetworksanddeeplearning.com/images/tikz16.png)

  ![img](http://neuralnetworksanddeeplearning.com/images/tikz17.png)

* With these notations, we have: 
  $$
  a_j^l = \sigma(\sum_k w_{jk}^la_k^{l-1} + b_j^l)
  $$
  We define _weight matrix_ $w^l$ for each layer $l$: the entries are the weights connecting to the $l^{th}$ layer of neurons, that is, the entry in the $j^{th}$ row and $k^{th}$ column is $w_{jk}^l$. Similarly, $b^l$ for _bias vector_, $a^l$ _activation vector_.

* A vectorized form:
  $$
  a^l = \sigma(w^la^{l-1} + b^l)
  $$
  that is, we just apply the weight matrix to the activations in the previous layer. We call $z^l \equiv w^l a^{l - 1} + b^l$ the _weighted input_ to the neurons in the layer $l$. So $a^l = \sigma(z^l)$. It's worth noting that $z^l$ has components $z_j^l = \sum_kw_{jk}^l a_k^{l - 1} + b_j^l$, that is, $z_j^k$ is just the weighted input to the activation function for neuron $j$ in layer $l$.

### The two assumptions we need about the cost function

* Recall the quadratic cost function: 

$$
C = \frac{1}{2n} \sum_z\|y(x) - a^L(x)\|^2
$$

 	L denote the number of layers in the network; $a^L = a^L(x)$ is the vector of activations output from the network where x is the input.

* The first assumption is that the cost function can be written as an average $C = \frac{1}{n}\sum_x C_x$ over cost function $C_x$ for individual training examples, x. For the quadratic cost, $C_x = \frac{1}{2}\|y - a^L\|^2$. The reason of this assumption is because what backpropagation actually lets us do is compute the partial derivatives   $\part C_x / \part w$ and $\part C_x / \part b$  for a single training example. We then recover $\part C / \part w$  and $\part C / \part b$ by averaging over training examples.

* The second assumption is that the cost function can be written as a function of the outputs from the neural network. The quadratic cost function satisfies this requirement, since the quadratic cost for a single training example x may be written as:
  $$
  C = \frac{1}{2}\|y - a^L\|^2 = \frac{1}{2}\sum_j(y_j - a_j^L)^2
  $$
  thus is a function of the output activations.

### The Hadamard product, $s \odot t$
* The components of $s \odot t$ are just $(s \odot t)_j = s_jt_j$.

### The four fundamental equations behind backpropagation

* ​