# Subsequence XOR Pairs
## Difficulty: Medium
<div class="problems_problem_content__Xm_eO"><p><span style="font-size: 14pt;">You are given an integer array <strong>arr[]</strong>. Out of all possible <strong>non-empty subsequences </strong>of <strong>arr[]</strong>, you need to find the number of pairs of these subseqences whose <strong>bitwise XOR</strong> are equal.<br>Since the number of pairs can be large, return the <strong>answer modulo 10<sup>9</sup> + 7</strong>.</span></p>
<p><span style="font-size: 14pt;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>arr[] = [1, 2, 3]<strong><br></strong><strong>Output:</strong> 3<br><strong>Explanation:</strong> The possible pairs of subsequence are:
[1] and [2, 3]
[2] and [1, 3]
[3] and [1, 2]
Hence, the answer is 3.</span></pre>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>arr[] = [4, 2, 2]<strong><br></strong><strong>Output:</strong> 3<br><strong>Explanation:</strong> The possible pairs of subsequence are:
[2] and [2]
[4, 2] and [4, 2]
[4] and [4, 2, 2]
Hence, the answer is 3.</span></pre>
<pre><span style="font-size: 14pt;"><strong>Input: </strong>arr = [7]<strong><br></strong><strong>Output:</strong> 0<br><strong>Explanation:</strong> There is only one subsequence [0] and hence no pairs are possible.</span></pre>
<p><span style="font-size: 14pt;"><strong>Constraints:<br></strong>1 ≤ |arr| ≤ 17<br>0 ≤ arr[i]&nbsp;≤ 10<sup>9</sup></span></p></div>