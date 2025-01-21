# Can you sort the array
## Difficulty: Easy
<div class="problems_problem_content__Xm_eO"><p>You are given two arrays, <strong>arr[]</strong> and <strong>frozen[]</strong>, of size <strong>n</strong>, both containing only 0s and 1s. You can swap elements at indices <strong>i</strong> and <strong>j</strong> (where <strong>0 ≤ i, j &lt; n</strong>) only if <strong>frozen[i] == 0</strong> and <strong>frozen[j] == 0</strong>.</p>
<p>Your task is to determine whether it is possible to sort <strong>arr</strong> in <strong>ascending order</strong> using any number of allowed swaps.</p>
<p><strong>Examples:</strong></p>
<pre><strong>Input:</strong> arr[] = [0, 1, 0, 1, 0, 0, 1], frozen[] = [1, 0, 1, 0, 0, 0, 1]<br><strong>Output:</strong> true<br><strong>Explanation:</strong> Swap elements at indices 1 and 5. Then, swap elements at indices 3 and 4 to sort the array.</pre>
<pre><strong>Input:</strong> arr[] = [1, 0, 1, 0, 1], frozen[] = [1, 0, 1, 1, 0]<br><strong>Output:</strong> false</pre>
<p><strong>Constraints:</strong></p>
<ul>
<li>1 ≤ n ≤ 10<sup>5</sup></li>
<li>arr[i] ∈ {0, 1}</li>
<li>frozen[i] ∈ {0, 1}</li>
</ul></div>