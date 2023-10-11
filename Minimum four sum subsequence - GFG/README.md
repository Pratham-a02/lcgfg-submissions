# Minimum four sum subsequence
## Easy
<div class="problems_problem_content__Xm_eO"><h1><span style="font-size:18px">Given an array A[] of positive integers. The task is to complete the function which returns an integer denoting the minimum sum&nbsp;<a href="http://www.geeksforgeeks.org/subarraysubstring-vs-subsequence-and-programs-to-generate-them/">subsequence</a>&nbsp;from the array such that at least one value among all groups of four consecutive elements is picked.</span></h1>

<p><span style="font-size:18px"><strong>Examples:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:</strong> A[] = {1, 2, 3, 4, 5, 6, 7, 8}
<strong>Output:</strong> 6
6 is sum of output subsequence {1, 5}
Following 4 length subarrays are possible
(1, 2, 3, 4), (2, 3, 4, 5), (3, 4, 5, 6),
(4, 5, 6, 7), (5, 6, 7, 8)
Here, Our subsequence {1, 5} has an element from all
above groups of four consecutive elements.

</span></pre>

<p><span style="font-size:18px">Input: A[] = {2, 1, 3} </span></p>

<p><span style="font-size:18px">Output:&nbsp;1 </span></p>

<pre><span style="font-size:18px">The N (size of A) is less than 4, so the subsequnce is {1}.</span></pre>

<pre>
<span style="font-size:18px"><strong>Input:</strong> A[] = {1, 2, 3, 3, 4, 5, 6, 1}
<strong>Output:</strong> 4
The subsequence is {3, 1}. Here we consider
second three.

</span></pre>

<p><span style="font-size:18px"><strong>Input:</strong><br>
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains two lines. The first line of each&nbsp;test case contains an integer N. Then in the next line are N space separated values of the array A[].<br>
<br>
<strong>Output:</strong><br>
For each test case in a new line output will be the min sum of such subsequence .<br>
<br>
<strong>Constraints:</strong><br>
1&lt;=T&lt;=100<br>
1&lt;=N&lt;=50<br>
1&lt;=A[]&lt;=1000<br>
<br>
<strong>Example(To be used only for expected output):<br>
Input:</strong><br>
2<br>
8<br>
1 2 3 4 5 6 7 8<br>
8<br>
1&nbsp;2&nbsp;3&nbsp;3&nbsp;4&nbsp;5&nbsp;6&nbsp;1<br>
<strong>Output:</strong><br>
6<br>
4</span></p>
</div>