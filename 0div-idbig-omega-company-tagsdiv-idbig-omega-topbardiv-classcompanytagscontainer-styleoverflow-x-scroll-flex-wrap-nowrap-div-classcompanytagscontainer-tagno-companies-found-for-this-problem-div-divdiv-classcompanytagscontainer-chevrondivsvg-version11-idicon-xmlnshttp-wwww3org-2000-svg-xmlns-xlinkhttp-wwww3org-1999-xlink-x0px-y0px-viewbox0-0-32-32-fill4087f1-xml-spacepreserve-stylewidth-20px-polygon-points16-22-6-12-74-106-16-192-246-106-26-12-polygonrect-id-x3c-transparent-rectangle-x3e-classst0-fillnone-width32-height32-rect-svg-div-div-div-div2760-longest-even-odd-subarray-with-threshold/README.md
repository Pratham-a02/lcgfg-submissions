<h2><a href="https://leetcode.com/problems/longest-even-odd-subarray-with-threshold/"><div id="big-omega-company-tags"><div id="big-omega-topbar"><div class="companyTagsContainer" style="overflow-x: scroll; flex-wrap: nowrap;"><div class="companyTagsContainer--tag">No companies found for this problem</div></div><div class="companyTagsContainer--chevron"><div><svg version="1.1" id="icon" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" viewBox="0 0 32 32" fill="#4087F1" xml:space="preserve" style="width: 20px;"><polygon points="16,22 6,12 7.4,10.6 16,19.2 24.6,10.6 26,12 "></polygon><rect id="_x3C_Transparent_Rectangle_x3E_" class="st0" fill="none" width="32" height="32"></rect></svg></div></div></div></div>2760. Longest Even Odd Subarray With Threshold</a></h2><h3>Easy</h3><hr><div><p>You are given a <strong>0-indexed</strong> integer array <code>nums</code> and an integer <code>threshold</code>.</p>

<p>Find the length of the <strong>longest subarray</strong> of <code>nums</code> starting at index <code>l</code> and ending at index <code>r</code> <code>(0 &lt;= l &lt;= r &lt; nums.length)</code> that satisfies the following conditions:</p>

<ul>
	<li><code>nums[l] % 2 == 0</code></li>
	<li>For all indices <code>i</code> in the range <code>[l, r - 1]</code>, <code>nums[i] % 2 != nums[i + 1] % 2</code></li>
	<li>For all indices <code>i</code> in the range <code>[l, r]</code>, <code>nums[i] &lt;= threshold</code></li>
</ul>

<p>Return <em>an integer denoting the length of the longest such subarray.</em></p>

<p><strong>Note:</strong> A <strong>subarray</strong> is a contiguous non-empty sequence of elements within an array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [3,2,5,4], threshold = 5
<strong>Output:</strong> 3
<strong>Explanation:</strong> In this example, we can select the subarray that starts at l = 1 and ends at r = 3 =&gt; [2,5,4]. This subarray satisfies the conditions.
Hence, the answer is the length of the subarray, 3. We can show that 3 is the maximum possible achievable length.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1,2], threshold = 2
<strong>Output:</strong> 1
<strong>Explanation:</strong> In this example, we can select the subarray that starts at l = 1 and ends at r = 1 =&gt; [2]. 
It satisfies all the conditions and we can show that 1 is the maximum possible achievable length.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [2,3,4,5], threshold = 4
<strong>Output:</strong> 3
<strong>Explanation:</strong> In this example, we can select the subarray that starts at l = 0 and ends at r = 2 =&gt; [2,3,4]. 
It satisfies all the conditions.
Hence, the answer is the length of the subarray, 3. We can show that 3 is the maximum possible achievable length.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 100 </code></li>
	<li><code>1 &lt;= nums[i] &lt;= 100 </code></li>
	<li><code>1 &lt;= threshold &lt;= 100</code></li>
</ul>
</div>